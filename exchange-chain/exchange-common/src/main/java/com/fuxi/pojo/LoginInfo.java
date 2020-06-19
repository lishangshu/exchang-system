package com.fuxi.pojo;

import com.fuxi.entity.Customer;
import com.fuxi.enums.CustomerStatusEnum;
import lombok.Builder;
import lombok.Data;

/**
 * @Auther: Laker
 * @Date: 2020/5/25 09:37
 * @Description: 登陆用户信息
 */
@Data
@Builder
public class LoginInfo {

    private String username;
    private int level;
    private String token;
    private String realName;
    private String avatar;
    private Long customerId;
    private String loginName;

    public static LoginInfo getLoginInfo(Customer customer) {
        return LoginInfo.builder().username(customer.getUserName())
                .avatar(customer.getAvatar())
                .level(customer.getLevel())
                .token(customer.getCurrentToken())
                .loginName(customer.getLoginName())
                .customerId(customer.getId())
                .build();
    }

}
