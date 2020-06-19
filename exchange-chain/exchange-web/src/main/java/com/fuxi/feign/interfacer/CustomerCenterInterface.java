package com.fuxi.feign.interfacer;

import com.fuxi.dto.MessageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: Laker
 * @Date: 2020/5/22 17:56
 * @Description:
 */
@FeignClient(value = "customer-center-exchange")
public interface CustomerCenterInterface {

    /**
     *  register by phone
     * @param phone
     * @param checkCode
     * @param ip
     * @return
     */
    @RequestMapping(value = "/customer/register/phone",method = RequestMethod.POST)
    MessageResult registerByPhone(@RequestParam("phone") String phone, @RequestParam("checkCode") String checkCode, @RequestParam("ip") String ip);

    /**
     *  login by phone
     * @param phone
     * @param checkCode
     * @param ip
     * @return
     */
    @RequestMapping(value = "/customer/login/phone",method = RequestMethod.POST)
    MessageResult loginByPhone(@RequestParam("phone") String phone, @RequestParam("checkCode") String checkCode, @RequestParam("ip") String ip);

    /**
     * realname auth
     * @param customerId
     * @param realName
     * @param idCard
     * @return
     */
    @RequestMapping(value = "/customer/auth/realName",method = RequestMethod.POST)
    MessageResult realNameAuthentication(@RequestParam("customerId") Long customerId, @RequestParam("realName") String realName, @RequestParam("idCard") String idCard);

    /**
     *  get account info
     * @param customerId
     * @return
     */
    @RequestMapping(value = "/customer/acquire/myAccount",method = RequestMethod.POST)
    MessageResult acquireMyAccount(@RequestParam("customerId") Long customerId);

    /**
     *  get account trans
     * @param customerId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/customer/acquire/transaction/list",method = RequestMethod.POST)
    MessageResult acquireMyTransactionList(@RequestParam("customerId") Long customerId,@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);

    @RequestMapping("/customer/auto/check/address")
    void checkAccountAddress();
}
