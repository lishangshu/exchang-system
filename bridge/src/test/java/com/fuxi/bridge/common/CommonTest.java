package com.fuxi.bridge.common;

import com.fuxi.bridge.BaseTest;
import com.fuxi.bridge.BaseTest;
import com.fuxi.bridge.utils.RedisUtil;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.crypto.gm.GenCredential;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;

/**
 * @Auther: Laker
 * @Date: 2020/5/27 10:09
 * @Description:
 */
public class CommonTest extends BaseTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void redisUtil(){
        boolean a = redisUtil.set("a", 10);
        System.out.println(a);
        Object a1 = redisUtil.get("a");
        System.out.println(a1);
    }


}
