package com.fuxi;

import com.fuxi.utils.WebToolUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableScheduling;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Logger;

@SpringBootApplication
@MapperScan("com.fuxi.dao")
@ComponentScan(basePackages = {"com.fuxi.controller","com.fuxi.serviceImpl","com.fuxi","com.fuxi.annotation"})
@EnableAutoConfiguration
@EnableCaching
@EnableScheduling
@EnableFeignClients(basePackages = {"com.fuxi.feign.interfacer"})
@EnableDiscoveryClient
public class ApplicationStarter implements CommandLineRunner {

	private static Logger log = Logger.getLogger(ApplicationStarter.class.getName());

	public static void main(String[] args) throws UnknownHostException, SocketException {
		Environment env = SpringApplication.run(ApplicationStarter.class, args).getEnvironment();
		String port = env.getProperty("server.port", "8080");
//		String hostAddress = InetAddress.getLocalHost().getHostAddress();
		String hostAddress = WebToolUtils.getLocalIP();
		log.info("Access URLs:\n----------------------------------------------------------\n\t"
						+ "Local: \t\thttp://127.0.0.1:"+port+"\n\t"
						+ "External: \thttp://"+hostAddress+":"+port+"\n----------------------------------------------------------");
		log.info("database:"+env.getProperty("spring.datasource.druid.url"));
	}

	@Override
	public void run(String... strings) throws Exception {
		log.info("\n _                        _                                           _   _   _ \n" +
				"| |                      | |                                         | | | | | |\n" +
				"| | __ _ _   _ _ __   ___| |__      ___ _   _  ___ ___ ___  ___ ___  | | | | | |\n" +
				"| |/ _` | | | | '_ \\ / __| '_ \\    / __| | | |/ __/ __/ _ \\/ __/ __| | | | | | |\n" +
				"| | (_| | |_| | | | | (__| | | |   \\__ \\ |_| | (_| (_|  __/\\__ \\__ \\ |_| |_| |_|\n" +
				"|_|\\__,_|\\__,_|_| |_|\\___|_| |_|   |___/\\__,_|\\___\\___\\___||___/___/ (_) (_) (_)\n" +
				"                                                                                ");


	}
}
