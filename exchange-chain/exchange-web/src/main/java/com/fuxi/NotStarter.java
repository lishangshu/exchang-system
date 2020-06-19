package com.fuxi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;

//@SpringBootApplication
@Slf4j
public class NotStarter {

    public static void main(String[] args) {
        SpringApplication.run(NotStarter.class, args);
        log.info("这个不是启动入口...");
    }
}
