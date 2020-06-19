package com.fuxi;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@MapperScan("com.fuxi.dao")
@ComponentScan(basePackages = {"com.fuxi.controller","com.fuxi.serviceImpl","com.fuxi","com.fuxi.annotation"})
@Slf4j
@EnableAutoConfiguration
@EnableCaching
@EnableFeignClients(basePackages = {"com.fuxi.feign.interfacer"})
@EnableDiscoveryClient
public class UsercenterProviderStarter implements CommandLineRunner {

    public static void main(String[] args) {
        ConfigurableEnvironment env = SpringApplication.run(UsercenterProviderStarter.class, args).getEnvironment();
        log.info("服务提供者启动成功...");
        log.info("database:"+env.getProperty("spring.datasource.druid.url"));
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("\n _                        _                                           _   _   _ \n" +
                "| |                      | |                                         | | | | | |\n" +
                "| | __ _ _   _ _ __   ___| |__      ___ _   _  ___ ___ ___  ___ ___  | | | | | |\n" +
                "| |/ _` | | | | '_ \\ / __| '_ \\    / __| | | |/ __/ __/ _ \\/ __/ __| | | | | | |\n" +
                "| | (_| | |_| | | | | (__| | | |   \\__ \\ |_| | (_| (_|  __/\\__ \\__ \\ |_| |_| |_|\n" +
                "|_|\\__,_|\\__,_|_| |_|\\___|_| |_|   |___/\\__,_|\\___\\___\\___||___/___/ (_) (_) (_)\n" +
                "                                                                                ");
    }
}
