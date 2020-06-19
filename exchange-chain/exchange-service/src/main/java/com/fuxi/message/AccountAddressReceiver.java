package com.fuxi.message;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuxi.bridge.pojo.AccountAddressMsg;
import com.fuxi.dao.CustomerMapper;
import com.fuxi.entity.Customer;
import com.fuxi.entity.CustomerExample;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @Auther: Laker
 * @Date: 2020/6/2 12:47
 * @Description: 异步初始化account地址账户
 */
@Component
@Slf4j
public class AccountAddressReceiver {

    @Autowired
    private CustomerMapper customerMapper;

    public void receiveMessage(String obj) {
        Jackson2JsonRedisSerializer seria = new Jackson2JsonRedisSerializer(AccountAddressMsg.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        seria.setObjectMapper(objectMapper);

        AccountAddressMsg accountAddress = (AccountAddressMsg) seria.deserialize(obj.getBytes());
//        处理业务
        String address = accountAddress.getAddress();
        String userCode = accountAddress.getUserCode();
        if (StringUtils.isNotBlank(address)) {
            Customer customer = new Customer();
            customer.setCode(userCode);
            customer.setAccountAddress(address);
            CustomerExample example = new CustomerExample();
            CustomerExample.Criteria criteria = example.createCriteria();
            criteria.andCodeEqualTo(userCode);
            int i = customerMapper.updateByExampleSelective(customer, example);
            log.info("初始化账户【{}地址为【{}】",userCode,address);
        } else {
            log.info("初始化账户【{}】失败!",userCode);
        }
    }
}
