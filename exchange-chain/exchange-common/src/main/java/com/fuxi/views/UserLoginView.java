package com.fuxi.views;

public class UserLoginView {

    /**
     *  操作人编码
     */
    private String loginCode;

    /**
     *  登录taken
     */
    private String token;

    /**
     *  手机号
     */
    private String mobile;

    /**
     * 后台接口版本号
     */
    private String apiVersion;

    /**
     *  操作级别
     */
    private Integer operatorLevel;

    /**
     *  账户类型
     */
    private String accountType;

    /**
     *  头像
     */
    private String avatar;

    /**
     *  是否已经设置密码
     */
    private Boolean havaPassword;

    /**
     *  用户code
     */
    private String userCode;


    public String getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public Integer getOperatorLevel() {
        return operatorLevel;
    }

    public void setOperatorLevel(Integer operatorLevel) {
        this.operatorLevel = operatorLevel;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getHavaPassword() {
        return havaPassword;
    }

    public void setHavaPassword(Boolean havaPassword) {
        this.havaPassword = havaPassword;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
