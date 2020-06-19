package com.fuxi.controller;

import com.fuxi.dto.MessageResult;
import com.fuxi.service.CustomerService;
import com.fuxi.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Laker
 * @Date: 2020/5/22 17:34
 * @Description:
 */
@RestController
@Configuration
@RequestMapping("/customer")
public class CustomerCenterController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ExchangeService exchangeService;

    @RequestMapping(value ="/register/phone",method = RequestMethod.POST)
    public MessageResult customerRegisterByPhone(String phone, String checkCode,String ip) {
        MessageResult result = customerService.registerByPhone(phone, checkCode, ip);
//        Asynchronous initialization accounts.
        if (result.getCode()==0) {
            String userCode = result.getMessage();
            exchangeService.initAccountAddress(userCode);
            result.setMessage("注册成功！");
            return result;
        }
        return result;
    }

    @RequestMapping(value = "/login/phone",method = RequestMethod.POST)
    public MessageResult loginByPhone(String phone,String checkCode,String ip) {
        return customerService.loginByPhone(phone, checkCode, ip);
    }

    @RequestMapping(value = "/auth/realName",method = RequestMethod.POST)
    public MessageResult realNameAuthentication(Long customerId,String realName ,String idCard) {
        return customerService.realNameAuthentication(customerId,realName,idCard);
    }

    @RequestMapping(value = "/acquire/myAccount",method = RequestMethod.POST)
    public MessageResult acquireMyAccount(Long customerId) {
        return exchangeService.acquireMyAccount(customerId);
    }

    @RequestMapping(value = "/acquire/transaction/list",method = RequestMethod.POST)
    public MessageResult acquireMyTransactionList(Long customerId,Integer pageNum,Integer pageSize) {
        return exchangeService.acquireMyTransactionList(customerId,pageNum,pageSize);
    }

    @RequestMapping("/auto/check/address")
    public void  checkAccountAddress() {
        customerService.autoCheckAccountAddress();
    }
}
