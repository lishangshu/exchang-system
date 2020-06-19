package com.fuxi.bridge;

import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.crypto.EncryptType;
import org.fisco.bcos.web3j.crypto.gm.GenCredential;
import org.junit.jupiter.api.Test;

/**
 * @Auther: Laker
 * @Date: 2020/4/2 14:12
 * @Description:
 */
public class CredentialTest {

    /**
     * privateKey:cdc20b9badffad97623202b0c1bdf7a6eff1890aac08f97dc3f8e07be68e83c5
     * publicKey:e8fd18c4429593da0e82f816e15ca2478a46539646554e920858949c71b7f3e62493eacf7ca9ceaf447506733cf0278f5c0724757a4c3ced6b7cc505c8867e43
     * address:0xaa959e0eee901597a55630ffbb18ace8b3734b9f
     */
    @Test
    public void getKeys(){
        EncryptType.encryptType = 0;
        Credentials credentials = GenCredential.create();
        String address = credentials.getAddress();
        String privateKey = credentials.getEcKeyPair().getPrivateKey().toString(16);
        String publicKey = credentials.getEcKeyPair().getPublicKey().toString(16);
        System.out.println("privateKey:"+privateKey);
        System.out.println("publicKey:"+publicKey);
        System.out.println("address:"+address);
    }
}
