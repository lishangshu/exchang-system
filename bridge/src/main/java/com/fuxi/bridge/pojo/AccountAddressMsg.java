package com.fuxi.bridge.pojo;

/**
 * @Auther: Laker
 * @Date: 2020/6/2 12:44
 * @Description:
 */
public class AccountAddressMsg {

    private String userCode;

    private String address;

    public AccountAddressMsg(String userCode, String address) {
        this.userCode = userCode;
        this.address = address;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
