package com.fuxi.bridge.service;

import com.fuxi.bridge.entity.AccountAddress;

/**
 * @Auther: Laker
 * @Date: 2020/5/28 15:35
 * @Description:
 */
public interface AccountAddressService {

    /**
     * @param userCode
     * @return
     */
    String createNewAddress(String userCode) ;

    /**
     * @param accountAddress
     * @return
     */
    AccountAddress findAccountByAddress(String accountAddress);
}
