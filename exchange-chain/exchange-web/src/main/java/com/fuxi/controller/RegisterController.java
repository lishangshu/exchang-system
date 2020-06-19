package com.fuxi.controller;

import com.alibaba.fastjson.JSONObject;
import com.fuxi.constant.SysConstant;
import com.fuxi.dto.MessageResult;
import com.fuxi.entity.Customer;
import com.fuxi.feign.interfacer.CustomerCenterInterface;
import com.fuxi.service.CustomerService;
import com.fuxi.utils.RedisUtil;
import com.fuxi.utils.ValidateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Auther: Laker
 * @Date: 2020/5/22 16:56
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping("/customer")
public class RegisterController extends BaseController{

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private CustomerCenterInterface centerInterface;

    /**
     *   register by phone.
     * @param params
     * @param request
     * @return
     */
    @RequestMapping("/register/phone")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public MessageResult registerByPhone(@RequestBody String params, HttpServletRequest request) {
        JSONObject body = super.optParamBody(params);
        String phone = body.getString("phone");
        String checkCode = body.getString("checkCode");
        Assert.notNull(checkCode,"请输入验证码");
        Assert.isTrue(ValidateUtil.isMobilePhone(phone),"手机号为空或格式错误");
        log.info("用户【{}】开始注册....", phone);
        String remoteAddr = request.getRemoteAddr();
        MessageResult result = centerInterface.registerByPhone(phone, checkCode,remoteAddr);
        return result;
    }
}
