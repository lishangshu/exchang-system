package com.fuxi.bridge.autoconfigure;

import org.fisco.bcos.web3j.crypto.EncryptType;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(
        prefix = "encrypt-type"
)
public class EncryptTypeConfig {
    private int encryptType;

    public EncryptTypeConfig() {
    }

    @Bean
    public EncryptType getEncryptType() {
        return new EncryptType(this.encryptType);
    }

    public void setEncryptType(int encryptType) {
        this.encryptType = encryptType;
    }
}
