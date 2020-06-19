package com.fuxi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: chenghaiming
 * @Date:2018/8/11
 * @Description：
 */
@Component
@ConfigurationProperties(prefix = "sms")
public class SmsConfig {

    private String appid;
    private String appkey;
    private String url;
    private String signType;
    private String timestampUrl;


    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getTimestampUrl() {
        return timestampUrl;
    }

    public void setTimestampUrl(String timestampUrl) {
        this.timestampUrl = timestampUrl;
    }
}
