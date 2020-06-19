package com.fuxi.service;

import com.fuxi.dto.MessageResult;

/**
 * @Auther: Laker
 * @Date: 2020/5/22 09:58
 * @Description:
 */
public interface CustomerService {

    public Boolean phoneIsExist(String phone);

    MessageResult registerByPhone(String phone, String checkCode, String ip);

    MessageResult loginByPhone(String phone, String checkCode, String ip);

    MessageResult realNameAuthentication(Long customerId, String realName, String idCard);

    void autoCheckAccountAddress();

    Boolean checkHaveBeenBought(Long sourceId, Long visitId);

    void insertCustomerPurchaseRecord(Long sourceId, Long visitId);

}
