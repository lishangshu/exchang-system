package com.fuxi.bridge.common;

import com.alibaba.fastjson.JSON;
import com.fuxi.bridge.BaseTest;
import com.fuxi.bridge.constants.ContractInfo;
import com.fuxi.bridge.contracts.StorageController;
import com.fuxi.bridge.constants.GasConstants;
import com.fuxi.bridge.dao.AccountAddressMapper;
import com.fuxi.bridge.entity.AccountAddress;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.crypto.gm.GenCredential;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tx.txdecode.InputAndOutputResult;
import org.fisco.bcos.web3j.tx.txdecode.TransactionDecoder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Auther: Laker
 * @Date: 2020/5/28 15:50
 * @Description:
 */
public class TestFunc extends BaseTest {

    @Autowired
    private Web3j web3j;

    @Value("${contracts.StorageController.address}")
    private String storageControllerAddress;

    @Value("${admin.keypairs.id}")
    private Long adminId;

    @Autowired
    private AccountAddressMapper accountAddressMapper;

    @Test
    public void  createNewAccount(){
        Credentials credentials = GenCredential.create();
        String s = JSON.toJSONString(credentials);
        System.out.println(s);
        String address = credentials.getAddress();
        System.out.println(address);
        String privateKey = credentials.getEcKeyPair().getPrivateKey().toString(16);
        String publicKey = credentials.getEcKeyPair().getPublicKey().toString(16);
        System.out.println(privateKey);
        System.out.println(publicKey);
    }

    @Test
    public void testConn() throws Exception {
        String address = "0xc00a1ff94726f92e2ea84458633c7365a179ceda";
        AccountAddress adminAccount = accountAddressMapper.selectByPrimaryKey(adminId);
        Credentials credentials = GenCredential.create(adminAccount.getPrivateKey());
        StorageController load = StorageController.load(storageControllerAddress, web3j, credentials, GasConstants.SGP);
        TransactionReceipt send = load.customerRegister(address).send();
        String status = send.getStatus();
        System.out.println(credentials.getAddress());
        TransactionDecoder transactionDecoder = load.getTransactionDecoder();
        InputAndOutputResult inputAndOutputResult = transactionDecoder.decodeOutputReturnObject(send.getInput(), send.getOutput());
        System.out.println(inputAndOutputResult);
        System.out.println(status);
    }
}
