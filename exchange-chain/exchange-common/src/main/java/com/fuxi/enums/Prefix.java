package com.fuxi.enums;

public enum Prefix {

    PREFIX_USER_LOGIN("CUSTOMER_LOGIN_", "用户登录"),
    PREFIX_H5_COINEARN_AUTH("COINEARN_AUTH_", "H5币权登录");

    public String code;
    public String desc;

    Prefix(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
