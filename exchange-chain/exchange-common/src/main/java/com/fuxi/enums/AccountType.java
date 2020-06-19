package com.fuxi.enums;

public enum AccountType {

    CUSTOMER_TYPE_ONE("USER_COMMON","普通用户",1);


    public String code;
    public String desc;
    public int level;

    AccountType(String code, String desc,int level) {
        this.code = code;
        this.desc = desc;
        this.level = level;
    }
}
