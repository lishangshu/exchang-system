package com.fuxi.bridge.controller;

import com.fuxi.bridge.service.ExchangeService;
import com.fuxi.bridge.pojo.Result;
import com.fuxi.bridge.service.AccountAddressService;
import com.fuxi.bridge.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: Laker
 * @Date: 2020/5/26 17:02
 * @Description:
 */
@RestController
@Configuration
@RequestMapping("/exchange")
@Slf4j
public class ExchangeController {

    @Autowired
    private ExchangeService exchangeService;

    @Autowired
    private AccountAddressService accountAddressService;

    @Autowired
    private TransactionService transactionService;

    /**
     * @param domainHash  domain hash
     * @param contentHash content hash
     * @param address       operator account address
     * @return
     */
    @RequestMapping(value = "/deposit/data/score",method = RequestMethod.POST)
    @ResponseBody
    public Result depositData2Chain(String domainHash, String contentHash, String address) throws Exception {
        return exchangeService.depositData2Chain(domainHash, contentHash, address);
    }

    /**
     *  get account score.
     * @param address
     * @return
     * @throws Exception
     */
    @RequestMapping("/get/myScore")
    @ResponseBody
    public Result getMyScore(String address) throws Exception {
        return exchangeService.getMyScore(address);
    }

    /**
     *  init new account address.
     * @param userCode
     * @return
     */
    @RequestMapping(value = "/create/newAddress",method = RequestMethod.POST)
    public String createNewAddress(String userCode){
            return accountAddressService.createNewAddress(userCode);
    }

    /**
     *  get account transcation record by account address.
     * @param address
     * @return
     */
    @RequestMapping(value ="/get/transaction/list",method = RequestMethod.POST)
    public Result getMyTransactionList(String address,Integer pageNum,Integer pageSize) {
        log.info("getMyTransactionList :{}",address);
        if (StringUtils.isNotBlank(address)) {
            return transactionService.getMyTransactionList(address,pageNum,pageSize);
        } else {
            log.info("address can not be null！");
            return Result.error("address is null！");
        }
    }


    /**
     * customer upload information to the blockchain and back up the data to the database.
     * @param domainHash
     * @param digestHash
     * @param accountAddress
     * @return
     */
    @RequestMapping(value = "/upload/digestHash/toChain",method = RequestMethod.POST)
    public Result uploadData2Chain(String domainHash, String digestHash, String accountAddress) {
        if (StringUtils.isNotBlank(domainHash) && StringUtils.isNotBlank(digestHash) && StringUtils.isNotBlank(accountAddress)) {
            return exchangeService.uploadData2Chain(domainHash, digestHash, accountAddress);
        }
        return Result.error("参数有误！");
    }

    /**
     *  spend score to check out the information.
     * @param domainHash
     * @param sourceAddress
     * @param visitorAddress
     * @return
     */
    @RequestMapping(value = "/visit/disgestHash",method = RequestMethod.POST)
    public Result visitDomainForDigestHashCode(String domainHash,String sourceAddress,String visitorAddress) throws Exception {
        return exchangeService.visitDomainDigestHashCode(domainHash,sourceAddress,visitorAddress);
    }

}
