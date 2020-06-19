package com.fuxi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class RegistrationApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RegistrationApplication.class,args);
        log.info("注册中心启动成功...");
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
