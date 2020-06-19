package com.fuxi.timer.schedule.task;

import com.fuxi.feign.interfacer.CustomerCenterInterface;
import com.fuxi.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Auther: Laker
 * @Date: 2020/6/2 10:39
 * @Description:
 */
@Component
@Slf4j
@EnableScheduling
public class CheckAccountAddressTask {

    @Autowired
    private CustomerCenterInterface centerInterface;

    /**
     * It is detected every 15 minutes and executed after 1 minute delay
     * Check the account address. Failed initializers will be initialized successfully after 12 minutes
     */
    @Scheduled(fixedDelay = 1000*60*5,initialDelay = 1000*60)
    public void checkAccountAddress(){
        log.info("启动检测账户地址程序--->【{}】",DateUtil.getStringFromDate(new Date(),DateUtil.FORMAT_DATETIME));
        centerInterface.checkAccountAddress();
        log.info("checkAccountAddress--->结束");
    }
}
