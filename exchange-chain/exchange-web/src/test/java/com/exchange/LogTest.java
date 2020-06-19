package com.fuxi;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class LogTest {


    @Test
    public void logTest(){
        System.out.println("测试开始");
        log.info("输出日志");
        System.out.println("结束");
    }
}
