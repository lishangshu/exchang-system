package com.fuxi.serviceImpl;

import com.fuxi.constant.CommonConst;
import com.fuxi.constant.SysConstant;
import com.fuxi.dao.CustomerMapper;
import com.fuxi.dao.CustomerPurchaseRecordMapper;
import com.fuxi.dto.MessageResult;
import com.fuxi.entity.Customer;
import com.fuxi.entity.CustomerExample;
import com.fuxi.entity.CustomerPurchaseRecord;
import com.fuxi.entity.CustomerPurchaseRecordExample;
import com.fuxi.enums.CustomerStatusEnum;
import com.fuxi.enums.Prefix;
import com.fuxi.pojo.LoginInfo;
import com.fuxi.service.CustomerService;
import com.fuxi.utils.CommonUtil;
import com.fuxi.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import static com.fuxi.dto.MessageResult.error;

/**
 * @Auther: Laker
 * @Date: 2020/5/22 10:08
 * @Description:
 */
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private CustomerPurchaseRecordMapper customerPurchaseRecordMapper;


    /**
     * check phone is already existed.
     * @param phone
     * @return
     */
    @Override
    public Boolean phoneIsExist(String phone) {
        CustomerExample example = new CustomerExample();
        CustomerExample.Criteria criteria = example.createCriteria();
        criteria.andMobileEqualTo(phone);
        return customerMapper.countByExample(example) > 0 ? true : false;
    }

    /**
     *  register by phone.
     * @param phone
     * @param checkCode
     * @param ip
     * @return
     */
    @Override
    public MessageResult registerByPhone(String phone, String checkCode, String ip) {
        String key = SysConstant.PHONE_REG_CODE_PREFIX + phone;
        Assert.isTrue(!phoneIsExist(phone),"该手机号已经注册，请登录！");
        Object code = redisUtil.get(key);
        Assert.notNull(code,"请先获取验证码");
        if (!code.toString().equals(checkCode)) {
            return error("验证码错误");
        } else {
            redisUtil.del(key);
        }
        Customer customer = new Customer();
        customer.setMobile(phone);
        customer.setCreateTime(new Date());
        customer.setUpdateTime(new Date());
        customer.setCode(CommonUtil.generateCode(Customer.class.getTypeName()));
        customer.setLastLoginIp(ip);
        customer.setLoginName(CommonUtil.generateDefaultUserName());
        customer.setLevel(CustomerStatusEnum.GENERAL.getOrdinal());
        int i = customerMapper.insertSelective(customer);
        if (i > 0) {
            String token = customerLoginHandler(customer);
            if (StringUtils.isBlank(token)) {
                log.info("【系统异常】，无法产生token！");
                return error("系统异常！");
            }
            customer.setCurrentToken(token);
            customer.setLastLoginTime(new Date());
            customerMapper.updateByPrimaryKeySelective(customer);
            LoginInfo loginInfo = LoginInfo.getLoginInfo(customer);
            MessageResult result = new MessageResult();
            result.setMessage(customer.getCode());
            result.setData(loginInfo);
            return result;
        }
        return error("注册失败！");
    }

    /**
     *  login by phone.
     * @param phone
     * @param checkCode
     * @param ip
     * @return
     */
    @Override
    public MessageResult loginByPhone(String phone, String checkCode, String ip) {
        String key = SysConstant.PHONE_REG_CODE_PREFIX + phone;
        String cacheCode = (String) redisUtil.get(key);
        Assert.isTrue(StringUtils.isNotBlank(cacheCode),"验证码已过期！");
        if (checkCode.equals(cacheCode)) {
            redisUtil.del(key);
            CustomerExample example = new CustomerExample();
            CustomerExample.Criteria criteria = example.createCriteria();
            criteria.andMobileEqualTo(phone);
            criteria.andLogicalDelEqualTo(CommonConst.LOGIC_NORMAL);
            List<Customer> customers = customerMapper.selectByExample(example);
            if (customers != null && customers.size() > 0) {
                Customer customer = customers.get(0);
                String newToken = customerLoginHandler(customer);
                customer.setLastLoginIp(ip);
                customer.setLastLoginTime(new Date());
                customer.setCurrentToken(newToken);
                customerMapper.updateByPrimaryKeySelective(customer);
                LoginInfo loginInfo = LoginInfo.getLoginInfo(customer);
                return MessageResult.success("登陆成功！",loginInfo);
            } else {
                return error("手机未注册，请先注册");
            }
        } else {
            return error("验证码错误");
        }
    }

    /**
     * @param customerId
     * @param realName
     * @param idCard
     * @return
     */
    @Override
    public MessageResult realNameAuthentication(Long customerId, String realName, String idCard) {
        Customer customer = new Customer();
        customer.setId(customerId);
        customer.setLevel(CustomerStatusEnum.REALNAME.getOrdinal());
        customer.setUserName(realName);
        customer.setIdCard(idCard);
        int i = customerMapper.updateByPrimaryKeySelective(customer);
        if (i > 0) {
            return MessageResult.success();
        } else {
            return MessageResult.error();
        }
    }

    /**
     * Timing automatic detection of users without an account address, and then initialization.
     */
    @Override
    public void autoCheckAccountAddress() {
        CustomerExample example = new CustomerExample();
        CustomerExample.Criteria criteria = example.createCriteria();
        criteria.andAccountAddressIsNull();
        CustomerExample.Criteria criteria1 = example.createCriteria();
        criteria1.andAccountAddressEqualTo("");
        example.or(criteria1);
        List<Customer> customers = customerMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(customers)) {
            customers.stream().forEach(customer ->redisUtil.sendRedisMQ(SysConstant.MQ_ACCOUNT_ADDRESS_REQUEST_TOPIC,customer.getCode()));
        }

    }

    /**
     *  Detects if the user has purchased viewing privileges
     * @param sourceId
     * @param visitId
     * @return
     */
    @Override
    public Boolean checkHaveBeenBought(Long sourceId, Long visitId) {
        if (null != sourceId && null != visitId) {
            CustomerPurchaseRecordExample example = new CustomerPurchaseRecordExample();
            CustomerPurchaseRecordExample.Criteria criteria = example.createCriteria();
            criteria.andDomainIdEqualTo(sourceId);
            criteria.andCustomerIdEqualTo(visitId);
            criteria.andStatusEqualTo(Boolean.TRUE);
            List<CustomerPurchaseRecord> list = customerPurchaseRecordMapper.selectByExample(example);
            if (list != null && list.size() > 0) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * @param sourceId
     * @param visitId
     */
    @Override
    public void insertCustomerPurchaseRecord(Long sourceId, Long visitId) {
        CustomerPurchaseRecord record = new CustomerPurchaseRecord();
        record.setCreateTime(new Date());
        record.setCustomerId(visitId);
        record.setDomainId(sourceId);
        record.setStatus(Boolean.TRUE);
        customerPurchaseRecordMapper.insertSelective(record);
    }

    /**
     *  login handler
     *
     * @param customer
     * @return
     */
    private String customerLoginHandler(Customer customer) {
        if (customer!=null) {
//            Replace the token.
            String currentToken = customer.getCurrentToken();
            if (StringUtils.isNoneBlank(currentToken)) {
                redisUtil.del(Prefix.PREFIX_USER_LOGIN.code+currentToken);
            }
//            create  new tokens.
            String token = CommonUtil.MD5(CommonUtil.UUID());
            redisUtil.set(Prefix.PREFIX_USER_LOGIN.code + token, customer.getCode(), CommonConst.CUSTOMER_TOKEN_DEADLINE);
            return token;
        }
        return null;
    }
}
