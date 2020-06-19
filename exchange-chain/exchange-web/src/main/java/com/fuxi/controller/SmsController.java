package com.fuxi.controller;

import com.fuxi.constant.SysConstant;
import com.fuxi.constant.UnitConst;
import com.fuxi.dto.MessageResult;
import com.fuxi.service.CustomerService;
import com.fuxi.utils.CommonUtil;
import com.fuxi.utils.CookieUtil;
import com.fuxi.utils.RedisUtil;
import com.fuxi.utils.ValidateUtil;
import com.fuxi.vendor.provider.SMSProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import static com.fuxi.dto.MessageResult.error;
import static com.fuxi.dto.MessageResult.success;


/**
 * @Auther: Laker
 * @Date: 2020/5/22 14:33
 * @Description:
 */
@RestController
@RequestMapping("/mobile")
@Slf4j
public class SmsController extends BaseController {

    @Autowired
    private SMSProvider smsProvider;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RedisUtil redisUtil;

    /**
     *  send verification code.
     * @param phone
     * @return
     */
    @PostMapping("/send/code")
    public MessageResult sendCheckCode(String phone, HttpServletRequest request) throws Exception {
        log.info("sendCheckCode:【{}】",phone);
//        Verify the phone number format
        Assert.isTrue(ValidateUtil.isMobilePhone(phone),"手机号格式不正确！");
        String ipAddress = CookieUtil.getIpAddress(request);
        log.info("用户ip【{}】", ipAddress);

        String key = SysConstant.PHONE_REG_CODE_PREFIX + phone;
        Object code = redisUtil.get(key);
        if (code != null) {
//            If a cell phone number repeatedly sends a text message within a minute, the request fails.
            if (redisUtil.get(key + "Time") != null) {
                return error("请求过于频繁，请稍候重试！");
            }
        }
        String randomCode = CommonUtil.getUniqueRandomInt(6);
        MessageResult result = smsProvider.sendVerifyMessage(phone, randomCode);
        if (result.getCode() == 0) {
            redisUtil.set(key, randomCode, UnitConst.TIME_MIN_FOR_SECOND * 5);
            redisUtil.set(key + "Time", phone, UnitConst.TIME_MIN_FOR_SECOND);
            return success("操作成功!");
        } else {
            return error("发送短信失败！");
        }
    }

}
