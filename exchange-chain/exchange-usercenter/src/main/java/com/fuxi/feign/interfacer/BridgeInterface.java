package com.fuxi.feign.interfacer;

import com.fuxi.dto.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: Laker
 * @Date: 2020/5/28 14:39
 * @Description:
 */
@FeignClient(value = "exchange-bridge")
public interface BridgeInterface {

    /**
     * Initializes the user account
     * @param userCode
     * @return
     */
    @RequestMapping(value = "/exchange/create/newAddress",method = RequestMethod.POST)
    String getAccountAddress(@RequestParam("userCode") String userCode);

    /**
     *  Get the user's credits
     * @param address
     * @return
     */
    @RequestMapping(value = "/exchange/get/myScore",method = RequestMethod.POST)
    Result getMyScore(@RequestParam("address") String address);

    /**
     * Obtain transaction records
     * @param address
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/exchange/get/transaction/list",method = RequestMethod.POST)
    Result getMyTransactionList(@RequestParam("address") String address,@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize) ;

    /**
     *  Upload summaries to the blockchain
     * @param domainHash
     * @param digestHash
     * @param accountAddress
     * @return
     */
    @RequestMapping(value = "/exchange/upload/digestHash/toChain",method = RequestMethod.POST)
    Result uploadData2Chain(@RequestParam("domainHash") String domainHash,@RequestParam("digestHash") String digestHash, @RequestParam("accountAddress") String accountAddress);

    /**
     *  Gets to the upload address
     * @param domainHash
     * @param sourceAddress
     * @param visitorAddress
     * @return
     */
    @RequestMapping(value = "/exchange/visit/disgestHash",method = RequestMethod.POST)
    Result getDomainDigestHashCode(@RequestParam("domainHash") String domainHash, @RequestParam("sourceAddress") String sourceAddress, @RequestParam("visitorAddress") String visitorAddress);
}
