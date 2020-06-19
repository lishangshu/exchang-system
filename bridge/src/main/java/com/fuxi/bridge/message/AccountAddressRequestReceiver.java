package com.fuxi.bridge.message;

import com.fuxi.bridge.pojo.AccountAddressMsg;
import com.fuxi.bridge.constants.SysConstants;
import com.fuxi.bridge.dao.AccountAddressMapper;
import com.fuxi.bridge.entity.AccountAddress;
import com.fuxi.bridge.entity.AccountAddressExample;
import com.fuxi.bridge.pojo.AccountAddressMsg;
import com.fuxi.bridge.service.AccountAddressService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: Laker
 * @Date: 2020/6/2 12:47
 * @Description:
 */
@Component
@Slf4j
public class AccountAddressRequestReceiver {

    @Autowired
    private AccountAddressMapper accountAddressMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private AccountAddressService accountAddressService;

    /**
     *  send feedback.
     * @param userCode
     */
    public void receiveMessage(String userCode) {
        if (StringUtils.isNotBlank(userCode)) {
            userCode=userCode.replace("\"", "");
            AccountAddressExample example = new AccountAddressExample();
            AccountAddressExample.Criteria criteria = example.createCriteria();
            criteria.andUserCodeEqualTo(userCode);
            List<AccountAddress> accountAddresses = accountAddressMapper.selectByExample(example);
            if (accountAddresses != null && accountAddresses.size() > 0) {
                redisTemplate.convertAndSend(SysConstants.MQ_ACCOUNT_ADDRESS_SEND_TOPIC, new AccountAddressMsg(userCode, accountAddresses.get(0).getAddress()));
            } else {
                String newAddress = accountAddressService.createNewAddress(userCode);
                if (StringUtils.isNotBlank(newAddress)) {
                    redisTemplate.convertAndSend(SysConstants.MQ_ACCOUNT_ADDRESS_SEND_TOPIC,new AccountAddressMsg(userCode,newAddress));
                }
            }
        }
    }
}
