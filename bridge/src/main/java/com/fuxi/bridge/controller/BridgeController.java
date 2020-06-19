//package com.fuxi.bridge.controller;
//
//import com.alibaba.fastjson.JSON;
//import com.fuxi.bridge.constants.ContractInfo;
//import com.fuxi.bridge.pojo.Result;
//import com.fuxi.bridge.utils.RedisUtil;
//import com.fuxi.bridge.constants.ContractInfo;
//import com.fuxi.bridge.contracts.KVTableTest;
//import com.fuxi.bridge.contracts.ScoreDB;
//import com.fuxi.bridge.pojo.Result;
//import com.fuxi.bridge.pojo.TransactionEventLogPushWithDecodeCallback;
//import com.fuxi.bridge.utils.RedisUtil;
//import org.apache.commons.lang3.StringUtils;
//import org.fisco.bcos.channel.client.Service;
//import org.fisco.bcos.channel.event.filter.*;
//import org.fisco.bcos.web3j.crypto.Credentials;
//import org.fisco.bcos.web3j.crypto.gm.GenCredential;
//import org.fisco.bcos.web3j.protocol.Web3j;
//import org.fisco.bcos.web3j.protocol.core.methods.response.BcosTransaction;
//import org.fisco.bcos.web3j.protocol.core.methods.response.BlockNumber;
//import org.fisco.bcos.web3j.protocol.core.methods.response.Transaction;
//import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
//import org.fisco.bcos.web3j.tuples.generated.Tuple3;
//import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.IOException;
//import java.math.BigInteger;
//import java.util.ArrayList;
//import java.util.Optional;
//
///**
// * @Auther: Laker
// * @Date: 2020/4/2 11:22
// * @Description: 获取当前快高度
// */
//@RestController
//@RequestMapping("/bridge")
//public class BridgeController {
//
//    @Autowired
//    private Web3j web3j;
//
//    @Autowired
//    private Service service;
//
//    @Autowired
//    private RedisUtil redisUtil;
//
//    /**
//     *  获取快高度
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping("/conn")
//    public String connect2BlockChain() throws Exception {
//        BigInteger blockNumber = web3j.getBlockNumber().send().getBlockNumber();
//        System.out.println(blockNumber);
//        return String.valueOf(blockNumber);
//    }
//
//    /**
//     * 调用合约存储信息
//     * @return
//     */
//    @RequestMapping(value = "/setKV",method = RequestMethod.POST)
//    public String saveInfoInContract(String domain,String ip) throws Exception {
//        BigInteger gasPrice = new BigInteger("300000000");
//        BigInteger gasLimit = new BigInteger("300000000");
//        Credentials credentials = GenCredential.create(ContractInfo.privateKey);
//        KVTableTest kvContract = KVTableTest.load(ContractInfo.contractAddress, web3j, credentials, new StaticGasProvider(gasPrice, gasLimit));
//        TransactionReceipt send = kvContract.set(domain, BigInteger.ONE, ip).send();
//        String transactionHash = send.getTransactionHash();
//        Result result = new Result();
//        if (StringUtils.isBlank(transactionHash)) {
//             result.setFlag(Boolean.FALSE);
//        } else {
//            result.setFlag(Boolean.TRUE);
//            result.setData(transactionHash);
//        }
//        return JSON.toJSONString(result).toString();
//    }
//
//    @RequestMapping(value = "/getKV")
//    public String getKVInfo(String domain) throws Exception {
//        BigInteger gasPrice = new BigInteger("300000000");
//        BigInteger gasLimit = new BigInteger("300000000");
//        Credentials credentials = GenCredential.create(ContractInfo.privateKey);
//        KVTableTest kvContract = KVTableTest.load(ContractInfo.contractAddress, web3j, credentials, new StaticGasProvider(gasPrice, gasLimit));
//        Tuple3<Boolean, BigInteger, String> send = kvContract.get(domain).send();
//        Result result = new Result();
//        result.setFlag(send.getValue1());
//        result.setData(send.getValue3());
//        return JSON.toJSONString(result).toString();
//    }
//
//    /**
//     * 0xcaa8e4d6e725c80319559490a8502a57c3fc6d04822edfaa82ff645cf87731d3
//     * @param transactionHash
//     * @return
//     */
//    @RequestMapping("/getTranstion/info/{transactionHash}")
//    public Transaction getTranstionInfo(@PathVariable String transactionHash) throws IOException {
//        BcosTransaction send = web3j.getTransactionByHash(transactionHash).send();
//        Optional<Transaction> transaction = send.getTransaction();
//        if (transaction.isPresent()) {
//            return transaction.get();
//        }
//        return null;
//    }
//
//    /**
//     * 当前区块高度
//     * @return
//     * @throws IOException
//     */
//    @RequestMapping("/getBlock/height")
//    public BigInteger getBlockHeight() throws IOException {
//        BlockNumber send = web3j.getBlockNumber().send();
//        return send.getBlockNumber();
//    }
//}
