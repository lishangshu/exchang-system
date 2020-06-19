package com.fuxi.controller;

import com.alibaba.fastjson.JSONObject;
import com.fuxi.annotation.LoginRequired;
import com.fuxi.dto.MessageResult;
import com.fuxi.feign.interfacer.CustomerCenterInterface;
import com.fuxi.utils.RedisUtil;
import com.fuxi.utils.ValidateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: Laker
 * @Date: 2020/5/25 11:05
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping("/customer")
public class LoginController extends BaseController {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private CustomerCenterInterface centerInterface;


    /**
     *  login by phone
     * @param params
     * @param request
     * @return
     */
    @RequestMapping(value = "/login/phone",method = RequestMethod.POST)
    @ResponseBody
    public MessageResult LoginByPhone(@RequestBody String params, HttpServletRequest request) {
        JSONObject body = super.optParamBody(params);
        String mobile = body.getString("mobile");
        String checkCode = body.getString("checkCode");
        log.info("用户开始登陆...【{}】验证码【{}】", mobile,checkCode);
        Assert.isTrue(ValidateUtil.isMobilePhone(mobile),"手机号格式有误！");
        Assert.isTrue(StringUtils.isNotBlank(mobile),"手机号不能为空");
        Assert.isTrue(StringUtils.isNotBlank(checkCode),"验证码不能为空！");
        String remoteAddr = request.getRemoteAddr();
        log.info("...IP地址...【{}】",remoteAddr);
        MessageResult result = centerInterface.loginByPhone(mobile,checkCode,remoteAddr);
        return result;
    }

    /**
     * @param params
     * @return
     */
    @RequestMapping(value = "/realname/auth")
    @ResponseBody
    @LoginRequired
    public MessageResult realNameAuthentication(@RequestBody String params){
        JSONObject head = super.optParamHead(params);
        JSONObject body = super.optParamBody(params);
        String realName = body.getString("realName");
        String idCard = body.getString("IdCard");
        Assert.isTrue(StringUtils.isNotBlank(realName)&&StringUtils.isNotBlank(idCard),"姓名或身份证号不能为空！");
        Long customerId = head.getLong("customerId");
        Assert.notNull(customerId, "参数有误！");
//      更改实名状态
        MessageResult result = centerInterface.realNameAuthentication(customerId,realName,idCard);
        return result;
    }
}
