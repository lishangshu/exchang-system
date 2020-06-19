package com.fuxi.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fuxi.constant.CommonConst;
import com.fuxi.constant.SysConstant;
import com.fuxi.dao.CustomerMapper;
import com.fuxi.dao.ExchangeDomainMapper;
import com.fuxi.dto.MessageResult;
import com.fuxi.dto.Result;
import com.fuxi.entity.Customer;
import com.fuxi.entity.ExchangeDomain;
import com.fuxi.entity.ExchangeDomainExample;
import com.fuxi.feign.interfacer.BridgeInterface;
import com.fuxi.pojo.ExchangeDomainVo;
import com.fuxi.service.CustomerService;
import com.fuxi.service.ExchangeService;
import com.fuxi.utils.HashUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Laker
 * @Date: 2020/5/26 14:20
 * @Description:
 */
@Service
@Slf4j
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private ExchangeDomainMapper exchangeDomainMapper;

    @Autowired
    private BridgeInterface bridgeInterface;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private CustomerService customerService;

    /**
     *  The user uploads data on the link (the link Hash must finally be splited with the address of the uploader).
     * @param
     * @return
     */
    @Override
    @Transactional
    public MessageResult customUploadData2Chain(String exchangeDomainJson) throws Exception{
        ExchangeDomain exchangeDomain = JSONObject.parseObject(exchangeDomainJson, ExchangeDomain.class);
        int items = 0;
        items = countNoNullField(exchangeDomain,items);
        Map<String, String> map = new HashMap<>();
        map = HashUtils.objectToMap(exchangeDomain, map);
//        Gets the user's account address.
        Customer customer = customerMapper.selectByPrimaryKey(exchangeDomain.getCustomerId());
//        Assert.isTrue(customer.getLevel()>0,"请先实名认证！");
        Assert.notNull(customer,"当前用户不存在！");
        Assert.isTrue(StringUtils.isNotBlank(customer.getAccountAddress()),"账户地址未初始化暂无法上传内容！");
        String linkString = HashUtils.createLinkString(map);
//        To ensure uniqueness, the user's account address must be added.
        linkString = linkString + "&account=" + customer.getAccountAddress();
        String hash = HashUtils.digestToHexStr(linkString);
//        Determine if the information in the database already exists, if it does, then refuse to resubmit, if it does not, then insert it (original record retention)
        Boolean b = checkHashIsExist(hash);
        if (b) {
            return MessageResult.error("请勿重复提交，数据已经存在");
        }
        String domainHash = HashUtils.digestToHexStr(exchangeDomain.getDomain().trim());
        exchangeDomain.setDomainHash(domainHash);
//        Store in database
        exchangeDomain.setContentItems(items);
        exchangeDomain.setCustomerAddress(customer.getAccountAddress());
        exchangeDomain.setCreateTime(new Date());
        exchangeDomain.setUpdateTime(new Date());
        exchangeDomain.setStatus(Boolean.TRUE);
        exchangeDomain.setHashCode(hash);
//        Invalidated record
        revocationEffectStatus(domainHash,customer.getAccountAddress());
        int i = exchangeDomainMapper.insertSelective(exchangeDomain);
//        message upload to blockchain.
        if (i > 0) {
            Result result = bridgeInterface.uploadData2Chain(domainHash, hash, customer.getAccountAddress());
            Assert.isTrue(result.getFlag(), "上链信息失败！");
//            Update the transaction hash to the corresponding record.
            exchangeDomain.setTransactionHash((String) result.getData());
            exchangeDomainMapper.updateByPrimaryKeySelective(exchangeDomain);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("transactionHash", result.getData());
            return MessageResult.success(jsonObject);
        } else {
            throw new RuntimeException("存储数据失败...");
        }
    }

    /**
     *  To cancel the original record status.
     * @param domainHash
     * @param accountAddress
     */
    private void revocationEffectStatus(String domainHash, String accountAddress) {
        ExchangeDomainExample example = new ExchangeDomainExample();
        ExchangeDomainExample.Criteria criteria = example.createCriteria();
        criteria.andDomainHashEqualTo(domainHash);
        criteria.andCustomerAddressEqualTo(accountAddress);
        ExchangeDomain exchangeDomain = new ExchangeDomain();
        exchangeDomain.setStatus(Boolean.FALSE);
        exchangeDomainMapper.updateByExampleSelective(exchangeDomain, example);
    }

    /**
     *  Check to see if the content hash already exists.
     * @param hash
     * @return
     */
    private Boolean checkHashIsExist(String hash) throws IllegalAccessException {
        if (StringUtils.isNotBlank(hash)) {
            ExchangeDomainExample example = new ExchangeDomainExample();
            ExchangeDomainExample.Criteria criteria = example.createCriteria();
            criteria.andHashCodeEqualTo(hash);
            return exchangeDomainMapper.countByExample(example) > 0 ? true : false;
        } else {
            throw new IllegalAccessException("checkHashIsExist:入参有误");
        }
    }

    /**
     *  Initialize account contract address (message queue)
     * @param userCode
     */
    @Override
    public void initAccountAddress(String userCode) {
        log.info("发送MQ初始化用户地址【{}】",userCode);
        redisTemplate.convertAndSend(SysConstant.MQ_ACCOUNT_ADDRESS_REQUEST_TOPIC,userCode);
    }

    /**
     *  Get user account information (including account balance)
     * @param customerId
     * @return
     */
    @Override
    public MessageResult acquireMyAccount(Long customerId) {
        Customer customer = customerMapper.selectByPrimaryKey(customerId);
        Assert.notNull(customer,"用户["+customerId+"]不存在");
        Assert.isTrue(StringUtils.isNotBlank(customer.getAccountAddress()),"用户[{"+customer.getId()+"}]地址账户未初始化");
        Map<String, Object> res = new HashMap<>();
        res.put("address", customer.getAccountAddress());
        res.put("realNameStatus", customer.getLevel() == 0 ? false : true);
        res.put("phone", customer.getMobile());
        res.put("score", getMyScore(customer.getAccountAddress()));
        return MessageResult.getSuccessInstance("success",res);
    }

    /**
     *  Get the score information.
     * @param address
     * @return
     */
    private BigDecimal getMyScore(String address) {
        Result result = bridgeInterface.getMyScore(address);
        BigDecimal score = BigDecimal.ZERO;
        if (result.getFlag()) {
            score = BigDecimal.valueOf((int)result.getData());
        }
        return score;
    }

    /**
     *  Get the transaction record information of the customer
     * @param customerId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public MessageResult acquireMyTransactionList(Long customerId, Integer pageNum, Integer pageSize) {
        if (customerId != null && customerId > 0) {
            Customer customer = customerMapper.selectByPrimaryKey(customerId);
            Assert.notNull(customer,"用户不存在！");
            String address = customer.getAccountAddress();
            Assert.isTrue(StringUtils.isNotBlank(address),"用户账户[address]不合法！");
            Map<String, Object> data = Maps.newHashMap();
            data.put("address", customer.getAccountAddress());
            data.put("score", getMyScore(customer.getAccountAddress()));
//            Get the transaction record of the user
            Result result = bridgeInterface.getMyTransactionList(address, pageNum, pageSize);
            data.put("transactions", result.getData());
            return MessageResult.success(data);
        }
        return MessageResult.error("参数有误");
    }

    /**
     *  get publish record.
     * @param customerId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public MessageResult findCustomePublishRecord(Long customerId, Integer pageNum, Integer pageSize) {
        ExchangeDomainExample example = new ExchangeDomainExample();
        example.setOrderByClause("id desc");
        ExchangeDomainExample.Criteria criteria = example.createCriteria();
        if (customerId != null && customerId > 0) {
            criteria.andCustomerIdEqualTo(customerId);
        }
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<ExchangeDomain> result = new PageInfo<>(exchangeDomainMapper.selectByExampleWithBLOBs(example));
        return MessageResult.success(result);
    }

    /**
     * Search the list of domain name results.
     * @param domain
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public MessageResult searchDomainListByDomainName(String domain, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Map<String,Object>> result = new PageInfo<>(exchangeDomainMapper.selectDomainSimpleList(domain,CommonConst.LOGIC_NORMAL,Boolean.TRUE));
        return MessageResult.success(result);
    }

    /**
     * View domain details.
     * @param sourceId
     * @param visitId
     * @return
     */
    @Override
    public MessageResult viewDomainDetail(Long sourceId, Long visitId) {
//        Check to see if you are viewing your own upload record
        if (checkIsOneOwn(sourceId,visitId)) {
            return MessageResult.success("own",JSON.toJSONString(exchangeDomainMapper.selectByPrimaryKey(sourceId)));
        }
//        Content that has already been purchased or viewed by the user is presented directly to the user
        if (customerService.checkHaveBeenBought(sourceId, visitId)) {
            return MessageResult.success("bought",JSON.toJSONString(exchangeDomainMapper.selectByPrimaryKey(sourceId)));
        }
        Customer visitor = customerMapper.selectByPrimaryKey(visitId);
//        Assert.isTrue(visitor.getLevel()>0,"请先进行实名认证！");
        ExchangeDomain exchangeDomain = exchangeDomainMapper.selectByPrimaryKey(sourceId);
        String customerAddress = exchangeDomain.getCustomerAddress();
        if (StringUtils.isBlank(customerAddress)) {
            ExchangeDomainVo domainVo = exchangeDomainMapper.findExchangeDomainAndPublisherById(sourceId);
            customerAddress = domainVo.getPublisher().getAccountAddress();
            Assert.isTrue(StringUtils.isNotBlank(customerAddress),"源账户地址不存在");
        }
        String visitorAddress = visitor.getAccountAddress();
        String domainHash = exchangeDomain.getDomainHash();
        Assert.isTrue(StringUtils.isNotBlank(domainHash),"域名hash有误！");
        Assert.isTrue(StringUtils.isNotBlank(visitorAddress), "账户地址未初始化或积分为0");
        Result result = bridgeInterface.getDomainDigestHashCode(domainHash, customerAddress,visitorAddress);
        if (result.getFlag()) {
            ExchangeDomainExample example = new ExchangeDomainExample();
            ExchangeDomainExample.Criteria criteria = example.createCriteria();
            criteria.andHashCodeEqualTo((String) result.getData());
            List<ExchangeDomain> exchangeDomains = exchangeDomainMapper.selectByExampleWithBLOBs(example);
            if (exchangeDomains != null && exchangeDomains.size() > 0) {
//                Insert user purchase record
                customerService.insertCustomerPurchaseRecord(sourceId, visitId);
                return MessageResult.success("payed",JSON.toJSONString(exchangeDomains.get(0)).toString());
            } else {
                MessageResult.error("查无此条数据");
            }
        } else {
            return MessageResult.error(result.getMsg());
        }
        return MessageResult.error("数据异常！");
    }

    /**
     *  Determine if the resource belongs to the user.
     * @param sourceId
     * @param visitId
     * @return
     */
    private Boolean checkIsOneOwn(Long sourceId, Long visitId) {
        Boolean res = false;
        ExchangeDomain exchangeDomain = exchangeDomainMapper.selectByPrimaryKey(sourceId);
        if (exchangeDomain != null) {
            if (visitId == exchangeDomain.getCustomerId()) {
                res = true;
            }
        }
        return res;
    }

    /**
     * Get general information about the record.
     * @param customerId
     * @param sourceId
     * @return
     */
    @Override
    public String getDomainScketchById(Long customerId, Long sourceId) {
        if (null!=customerId&&null!=sourceId) {
            Map<String,Object> map = exchangeDomainMapper.selectWhoIsById(sourceId);
            if (checkIsOneOwn(sourceId, customerId)) {
                map.put("hasBought", Boolean.TRUE);
            } else {
                map.put("hasBought", customerService.checkHaveBeenBought(sourceId, customerId));
            }

            return JSON.toJSONString(map).toString();
        }
        return null;
    }


    /**
     *  Filter properties that are not null in the property.
     * @param obj
     * @param count
     * @return
     */
    private int countNoNullField(Object obj, int count) {
        if (obj == null) {
            return count;
        }
        try {
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                if (field.get(obj) instanceof String) {
                    if (field.get(obj)!=null&&(String)((String) field.get(obj)).trim()!="") {
                        count++;
                    }
                }
            }
        } catch (Exception e) {

        }

        return count;
    }
}
