package com.fuxi.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuxi.constant.SysConstant;
import com.fuxi.message.AccountAddressReceiver;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * @Auther: Laker
 * @Date: 2020/6/2 16:00
 * @Description: redis消息队列配置工具类
 */
@Configuration
@EnableCaching
public class RedisMqConfig {

    /**
     *  可以订阅多个频道
     * @param connectionFactory
     * @param listenerAdapter  可以订阅多换个频道
     * @return
     */
    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
//        订阅频道
        container.addMessageListener(listenerAdapter,new PatternTopic(SysConstant.MQ_ACCOUNT_ADDRESS_SUBSCRIPTION_TOPIC));
//        序列化对象（同时发布的时候也需要设置序列化，订阅方也需要设置序列化）
        Jackson2JsonRedisSerializer seria = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        seria.setObjectMapper(om);
        container.setTopicSerializer(seria);
        return container;
    }


//      表示监听一个频道
    @Bean
    public MessageListenerAdapter accountAddresslistenerAdapter(AccountAddressReceiver receiver) {
//     此处是给适配器传入一个消息接收处理器，利用反射原理执行接收方法
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }
}
