package com.fuxi.dao;

import com.fuxi.BaseTest;
import com.fuxi.bridge.pojo.AccountAddressMsg;
import com.fuxi.constant.SysConstant;
import com.fuxi.pojo.ExchangeDomainVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Auther: Laker
 * @Date: 2020/6/2 09:19
 * @Description:
 */
public class DaoTest extends BaseTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ExchangeDomainMapper exchangeDomainMapper;

    @Test
    public void daoTest(){
        ExchangeDomainVo domainVo = exchangeDomainMapper.findExchangeDomainAndPublisherById(1L);
        String address = domainVo.getPublisher().getAccountAddress();
        System.out.println(address);
    }

    @Test
    public void  MessageTest(){
        AccountAddressMsg accountAddress = new AccountAddressMsg();
        accountAddress.setUserCode("xxx");
        accountAddress.setAddress("papapa");
        redisTemplate.convertAndSend(SysConstant.MQ_ACCOUNT_ADDRESS_SUBSCRIPTION_TOPIC, accountAddress);
    }
}
