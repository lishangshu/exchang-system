package com.fuxi.controller;

import com.alibaba.fastjson.JSONObject;
import com.fuxi.annotation.LoginRequired;
import com.fuxi.dto.MessageResult;
import com.fuxi.entity.ExchangeDomain;
import com.fuxi.feign.interfacer.ExchangeOperInterface;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: Laker
 * @Date: 2020/5/25 15:13
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping("/exchange")
public class ExchangeController extends BaseController {

    @Autowired
    private ExchangeOperInterface exchangeOperInterface;

    /**
     *   It does not cost credits to query the list of domain names
     * @return
     */
    @RequestMapping(value = "/search/domains",method = RequestMethod.POST)
    @ResponseBody
    public MessageResult searchDomain(@RequestBody String params){
        JSONObject body = super.optParamBody(params);
        String domain = body.getString("domain");
        Integer pageNum = body.getInteger("pageNum") == null ? 1 : body.getInteger("pageNum");
        Integer pageSize = body.getInteger("pageSize") == null ? 10 : body.getInteger("pageSize");
        log.info("查询的域名domin【{}】",domain);
        Assert.isTrue(StringUtils.isNotBlank(domain), "请输入要查询的域名！");
        return exchangeOperInterface.searchDomainList(domain,pageNum,pageSize);
    }

    /**
     *  Get rough information based on id
     * @param params
     * @return
     */
    @RequestMapping(value = "/get/sketchById",method = RequestMethod.POST)
    @ResponseBody
    public MessageResult getDomainSketchyInfo(@RequestBody String  params) {
        JSONObject head = super.optParamHead(params);
        JSONObject body = super.optParamBody(params);
        Long customerId = head.getLong("customerId");
        Long sourceId = body.getLong("sourceId");
        if (null!=customerId&&sourceId!=null) {
            return MessageResult.success("success",exchangeOperInterface.getDomainSketchById(customerId,sourceId));
        }
        return MessageResult.error("参数有误！");
    }


    /**
     *  View others information data exchange and exchange credits.
     * @param params
     * @return
     */
    @RequestMapping(value = "/view/domain/details",method = RequestMethod.POST)
    @LoginRequired
    @ResponseBody
    public MessageResult viewExchagenDomainDetails(@RequestBody String params) {
        JSONObject head = super.optParamHead(params);
        JSONObject body = super.optParamBody(params);
        Long sourceId = body.getLong("sourceId");
        Long visitId = head.getLong("customerId");
        Assert.notNull(visitId,"用户id不能为空");
        Assert.notNull(sourceId,"资源id不能为空！");
        return exchangeOperInterface.viewExchangeDomainDetail(sourceId,visitId);
    }

    /**
     *  Data to the blockchain
     * @param params
     * @return
     */
    @RequestMapping(value = "/data/up2/chain",method = RequestMethod.POST)
    @ResponseBody
    @LoginRequired
    public MessageResult dataUp2Chain(@RequestBody String params) {
        JSONObject body = optParamBody(params);
        JSONObject head = super.optParamHead(params);
        Long customerId = head.getLong("customerId");
        if (null==customerId||customerId==0) return error("请登录后再操作！");
        String domain = body.getString("domain");
        Assert.isTrue(StringUtils.isNotBlank(domain),"域名不能为空！");
        String dnsParseRecord = body.getString("dnsParseRecord");
        Assert.isTrue(StringUtils.isNotBlank(dnsParseRecord),"解析记录参数有误！");
        ExchangeDomain exchangeDomain = new ExchangeDomain();
        exchangeDomain.setCustomerId(customerId);
        exchangeDomain.setDomain(domain);
        exchangeDomain.setDnsParseRecord(dnsParseRecord);
        exchangeDomain.setOwner(body.getString("owner"));
        exchangeDomain.setPosition(body.getString("position"));
        exchangeDomain.setMailAddress(body.getString("mailAddress"));
        exchangeDomain.setMaillNo(body.getString("maillNo"));
        exchangeDomain.setContactPhone(body.getString("contactPhone"));
        exchangeDomain.setEmail(body.getString("email"));

        exchangeDomain.setWiRegistrarSupport(body.getString("wiSupport"));
        exchangeDomain.setWiCreateTime(body.getString("wiCreateTime"));
        exchangeDomain.setWiExpirationTime(body.getString("wiExpirationTime"));
        exchangeDomain.setWiServerIp(body.getString("wiServerIp"));
        exchangeDomain.setWiDns(body.getString("wiDns"));

        String exchangeDomainJson = JSONObject.toJSONString(exchangeDomain);
        MessageResult result = exchangeOperInterface.customeUploadData2Chain(exchangeDomainJson);
        return result;
    }
}
