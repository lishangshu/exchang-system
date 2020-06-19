package com.fuxi.controller;

import com.alibaba.fastjson.JSONObject;
import com.fuxi.annotation.LoginRequired;
import com.fuxi.dto.MessageResult;
import com.fuxi.feign.interfacer.CustomerCenterInterface;
import com.fuxi.feign.interfacer.ExchangeOperInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: Laker
 * @Date: 2020/5/25 15:17
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping("/customer")
public class CustomerController extends BaseController{

    @Autowired
    private CustomerCenterInterface centerInterface;

    @Autowired
    private ExchangeOperInterface exchangeOperInterface;

    /**
     *  Get user account information
     * @param params
     * @return
     */
    @RequestMapping(value = "/acquire/myAccount",method = RequestMethod.POST)
    @LoginRequired
    public MessageResult acquireMyAccount(@RequestBody String params) {
        JSONObject head = super.optParamHead(params);
        Long customerId = head.getLong("customerId");
        return centerInterface.acquireMyAccount(customerId);
    }


    /**
     * Get the user's own transaction records
     *
     * @return
     */
    @RequestMapping(value = "/acquire/transactions", method = RequestMethod.POST)
    @LoginRequired
    public MessageResult acquireMyTransactionList(@RequestBody String params) {
        JSONObject head = super.optParamHead(params);
        JSONObject body = super.optParamBody(params);
        Integer pageNum = body.getInteger("pageNum") == null ? 1 : body.getInteger("pageNum");
        Integer pageSize = body.getInteger("pageSize") == null ? 10 : body.getInteger("pageSize");
        Long customerId = head.getLong("customerId");

        Assert.isTrue(null!=customerId&&customerId>0, "参数有误！");
        return centerInterface.acquireMyTransactionList(customerId,pageNum,pageSize);
    }

    /**
     *  View your own release history
     * @param params
     * @return
     */
    @RequestMapping(value = "/check/publish/record",method = RequestMethod.POST)
    @LoginRequired
    public MessageResult checkMyPublishRecord(@RequestBody String params) {
        JSONObject head = super.optParamHead(params);
        JSONObject body = super.optParamBody(params);
        Integer pageNum = body.getInteger("pageNum") == null ? 1 : body.getInteger("pageNum");
        Integer pageSize = body.getInteger("pageSize") == null ? 10 : body.getInteger("pageSize");
        Long customerId = head.getLong("customerId");
        return exchangeOperInterface.findCustomePublishRecord(customerId, pageNum, pageSize);
    }

}
