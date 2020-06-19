package com.fuxi.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: Laker
 * @Date: 2020/5/25 09:38
 * @Description:
 */
@AllArgsConstructor
@Getter
public enum  CustomerStatusEnum implements BaseEnum{


    GENERAL( "普通"),
    REALNAME("实名"),
    IDENTIFICATION("认证商家");

    @Setter
    private String cnName;

    @Override
    @JsonValue
    public int getOrdinal(){
        return this.ordinal();
    }
}
