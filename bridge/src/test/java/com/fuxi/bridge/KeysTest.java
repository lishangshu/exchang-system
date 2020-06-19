package com.fuxi.bridge;


import org.apache.commons.lang3.StringUtils;
import org.fisco.bcos.web3j.crypto.ECKeyPair;
import org.fisco.bcos.web3j.crypto.Keys;
import org.junit.Test;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * @Auther: Laker
 * @Date: 2020/6/15 17:53
 * @Description:
 */
public class KeysTest {

    @Test
    public void KeysTest1(){
        ECKeyPair ecKeyPair = null;
        try {
            ecKeyPair = Keys.createEcKeyPair();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
        BigInteger publicKey = ecKeyPair.getPublicKey();
        System.out.println(publicKey);
        String address = Keys.getAddress(publicKey);
        System.out.println(address);
        boolean contains = StringUtils.contains(address, "0x");
        System.out.println(contains);
    }
}
