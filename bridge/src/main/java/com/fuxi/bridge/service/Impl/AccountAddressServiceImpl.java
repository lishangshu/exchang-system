package com.fuxi.bridge.service.Impl;

import com.alibaba.fastjson.JSON;
import com.fuxi.bridge.constants.ContractInfo;
import com.fuxi.bridge.contracts.StorageController;
import com.fuxi.bridge.service.AccountAddressService;
import com.fuxi.bridge.constants.GasConstants;
import com.fuxi.bridge.dao.AccountAddressMapper;
import com.fuxi.bridge.entity.AccountAddress;
import com.fuxi.bridge.entity.AccountAddressExample;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.crypto.gm.GenCredential;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Auther: Laker
 * @Date: 2020/5/28 15:35
 * @Description:
 */
@Service
@Slf4j
public class AccountAddressServiceImpl implements AccountAddressService {

    @Autowired
    private AccountAddressMapper accountAddressMapper;

    @Autowired
    private Web3j web3j;

    @Value("${contracts.StorageController.address}")
    private String storageControllerAddress;

    @Value("${admin.keypairs.id}")
    private Long adminId;

    @Override
    public String createNewAddress(String userCode) {
        if (StringUtils.isNotBlank(userCode)) {
            Credentials credentials = GenCredential.create();
            AccountAddress accountAddress = new AccountAddress();
            accountAddress.setUserCode(userCode);
            accountAddress.setAddress(credentials.getAddress());
            accountAddress.setPublicKey(credentials.getEcKeyPair().getPublicKey().toString(16));
            accountAddress.setPrivateKey(credentials.getEcKeyPair().getPrivateKey().toString(16));
            accountAddress.setCreateTime(new Date());
            accountAddress.setUpdateTime(new Date());
            accountAddress.setCredentials(JSON.toJSONString(credentials));
//            write in the database after activating the account successfully.
            if (activateAccount(credentials.getAddress())) {
                accountAddress.setStatus(Boolean.TRUE);
                int i = accountAddressMapper.insertSelective(accountAddress);
                log.info("创建新账户【{}】,【{}】", userCode, credentials.getAddress());
                return credentials.getAddress();
            }
        }
        return null;
    }

    @Override
    public AccountAddress findAccountByAddress(String accountAddress) {
        AccountAddressExample example = new AccountAddressExample();
        AccountAddressExample.Criteria criteria = example.createCriteria();
        criteria.andAddressEqualTo(accountAddress);
        List<AccountAddress> accountAddresses = accountAddressMapper.selectByExample(example);
        if (accountAddresses != null && accountAddresses.size() > 0) {
            return accountAddresses.get(0);
        } else {
            return null;
        }

    }

    /**
     * Activate the account（only admin can operate）.
     *
     * @param address
     */
    private Boolean activateAccount(String address) {
        AccountAddress adminAccount = accountAddressMapper.selectByPrimaryKey(adminId);
        Credentials credentials = GenCredential.create(adminAccount.getPrivateKey());
        StorageController contract = StorageController.load(storageControllerAddress, web3j, credentials, GasConstants.SGP);
        TransactionReceipt transactionReceipt = null;
        try {
            transactionReceipt = contract.customerRegister(address).send();
        } catch (Exception e) {
            log.info("激活账户【{}】失败", address);
            e.printStackTrace();
            return Boolean.FALSE;
        }
        String status = transactionReceipt.getStatus();
        if (ContractInfo.SUCCESS_STATUS.equals(status)) {
            if ("0x".equals(transactionReceipt.getOutput())) {
                log.info("成功激活账户【{}】+++++++++++++++++++", address);
            }
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
