package com.fuxi.config;

import com.fuxi.vendor.provider.SMSProvider;
import com.fuxi.vendor.provider.support.TwoFiveThreeProvider;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SmsProviderConfig {

    @Value("${sms.gateway:}")
    private String gateway;
    @Value("${sms.username:}")
    private String username;
    @Value("${sms.password:}")
    private String password;
    @Value("${sms.sign:}")
    private String sign;

    @Bean
    public SMSProvider getSMSProvider(@Value("${sms.driver:}") String driverName) {
        if(driverName.equalsIgnoreCase(TwoFiveThreeProvider.getName())){
            return new TwoFiveThreeProvider(gateway,username,password,sign);
        }  else {
            return null;
        }
    }
}
