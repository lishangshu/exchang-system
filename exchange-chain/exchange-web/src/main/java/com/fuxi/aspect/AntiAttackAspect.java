package com.fuxi.aspect;

import com.fuxi.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: Laker
 * @Date: 2020/5/22 14:25
 * @Description: Faceted becomes an anti-attack
 */
@Slf4j
@Component
@Aspect
public class AntiAttackAspect {

    @Autowired
    private RedisUtil redisUtil;

    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    public  void  antiAttack(){

    }


}
