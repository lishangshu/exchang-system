package com.fuxi.bridge.service.Impl;

import com.fuxi.bridge.constants.ContractInfo;
import com.fuxi.bridge.dao.AccountAddressMapper;
import com.fuxi.bridge.service.ExchangeService;
import com.fuxi.bridge.constants.GasConstants;
import com.fuxi.bridge.contracts.StorageController;
import com.fuxi.bridge.entity.AccountAddress;
import com.fuxi.bridge.pojo.Result;
import com.fuxi.bridge.service.AccountAddressService;
import org.apache.commons.lang3.StringUtils;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.crypto.gm.GenCredential;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.protocol.exceptions.TransactionException;
import org.fisco.bcos.web3j.tx.txdecode.BaseException;
import org.fisco.bcos.web3j.tx.txdecode.InputAndOutputResult;
import org.fisco.bcos.web3j.tx.txdecode.TransactionDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * @Auther: Laker
 * @Date: 2020/5/26 17:05
 * @Description:
 */
@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    private Web3j web3j;

    @Autowired
    private AccountAddressService accountAddressService;

    @Value("${contracts.StorageController.address}")
    private String storageControllerAddr;

    @Autowired
    private AccountAddressMapper accountAddressMapper;

    @Value("${admin.keypairs.id}")
    private Long adminId;

    /**
     *  Abandoned
     * @param domainHash
     * @param contentHash
     * @param address
     * @return
     * @throws Exception
     */
    @Override
    public Result depositData2Chain(String domainHash, String contentHash, String address) throws Exception {
        AccountAddress adminAccount = accountAddressMapper.selectByPrimaryKey(adminId);
        Credentials credentials = GenCredential.create(adminAccount.getPrivateKey());
        StorageController sCContract = StorageController.load(storageControllerAddr, web3j, credentials, GasConstants.SGP);
        TransactionReceipt transactionReceipt = sCContract.storeInfomation(domainHash, contentHash).send();
        String output = transactionReceipt.getOutput();
        String status = transactionReceipt.getStatus();
        String transactionHash = transactionReceipt.getTransactionHash();
        return Result.success();
    }

    /**
     *  Get account's score.
     * @param address
     * @return
     */
    @Override
    public Result getMyScore(String address) throws Exception {
        AccountAddress adminAccount = accountAddressMapper.selectByPrimaryKey(adminId);
        Credentials credentials = GenCredential.create(adminAccount.getPrivateKey());
        StorageController scContract = StorageController.load(storageControllerAddr, web3j, credentials, GasConstants.SGP);
        TransactionReceipt send = scContract.getMyScore(address).send();
        String output = send.getOutput();
        String input = send.getInput();
        String status = send.getStatus();
        if (ContractInfo.SUCCESS_STATUS.equals(status)) {
            TransactionDecoder transactionDecoder = StorageController.transactionDecoder;
            InputAndOutputResult inputAndOutputResult = transactionDecoder.decodeOutputReturnObject(input, output);
            return Result.success(inputAndOutputResult.getResult().get(0).getData());
        }
        return Result.error("查询失败");
    }

    /**
     *  Upload info to the blockchain.
     * @param domainHash
     * @param digestHash
     * @param accountAddress
     * @return  transcation hash
     */
    @Override
    public Result uploadData2Chain(String domainHash, String digestHash, String accountAddress) {
        AccountAddress byAddress = accountAddressService.findAccountByAddress(accountAddress);
        if (null != byAddress) {
            Credentials credentials = GenCredential.create(byAddress.getPrivateKey());
            StorageController loader = StorageController.load(storageControllerAddr, web3j, credentials, GasConstants.SGP);
            try {
                TransactionReceipt transactionReceipt = loader.storeInfomation(domainHash, digestHash).send();
                if (ContractInfo.SUCCESS_STATUS.equals(transactionReceipt.getStatus())) {
                   return Result.success(transactionReceipt.getTransactionHash());
                }
            } catch (Exception e) {
                e.printStackTrace();
                return Result.error("上链数据异常！");
            }
        }
        return Result.error("用户地址不存在");
    }

    /**
     *  Get domain digest hash.
     * @param domainHash
     * @param sourceAddress
     * @param visitorAddress
     * @return
     */
    @Override
    public Result visitDomainDigestHashCode(String domainHash, String sourceAddress, String visitorAddress) throws Exception {
        if (StringUtils.isNotBlank(domainHash) && StringUtils.isNotBlank(sourceAddress) && StringUtils.isNotBlank(visitorAddress)) {
            AccountAddress visitAccount = accountAddressService.findAccountByAddress(visitorAddress);
            if (visitAccount != null) {
                Credentials credentials = GenCredential.create(visitAccount.getPrivateKey());
                StorageController storageController = StorageController.load(storageControllerAddr, web3j, credentials, GasConstants.SGP);
                TransactionReceipt transactionReceipt = storageController.checkOthersSubmissions(domainHash, sourceAddress).send();
                if (ContractInfo.SUCCESS_STATUS.equals(transactionReceipt.getStatus())) {
                    TransactionDecoder transactionDecoder = StorageController.transactionDecoder;
                    try {
                        InputAndOutputResult inputAndOutputResult = transactionDecoder.decodeOutputReturnObject(transactionReceipt.getInput(), transactionReceipt.getOutput());
                        return Result.success(((String) inputAndOutputResult.getResult().get(0).getData()).trim());
                    } catch (TransactionException e) {
                        e.printStackTrace();
                        return Result.error();
                    } catch (BaseException e) {
                        e.printStackTrace();
                        return Result.error();
                    }
                } else {
                    return Result.error("交易失败，可能积分不足！");
                }
            } else {
                return Result.error("找不到访问者账户信息");
            }
        }
        return Result.error("数据异常！");
    }
}
