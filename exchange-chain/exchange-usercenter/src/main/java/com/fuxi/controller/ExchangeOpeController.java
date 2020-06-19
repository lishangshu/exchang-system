package com.fuxi.controller;

import com.fuxi.dto.MessageResult;
import com.fuxi.feign.interfacer.BridgeInterface;
import com.fuxi.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;


/**
 * @Auther: Laker
 * @Date: 2020/5/26 14:17
 * @Description:
 */
@RestController
@Configuration
@RequestMapping("/exchange")
public class ExchangeOpeController {

    @Autowired
    private BridgeInterface bridgeInterface;

    @Autowired
    private ExchangeService exchangeService;


    @RequestMapping(value = "/upload/chain",method = RequestMethod.POST)
    public MessageResult customeUploadData2Chain(String exchangeDomainJson) throws Exception {
        return exchangeService.customUploadData2Chain(exchangeDomainJson);
    }

    /**
     *   Find published records.
     * @param customerId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @PostMapping(value = "/publish/record")
    public MessageResult findCustomePublishRecord(Long customerId,Integer pageNum,Integer pageSize) {
        return exchangeService.findCustomePublishRecord(customerId,pageNum,pageSize);
    }

    /**
     *  Query the domain name list
     * @return
     */
    @RequestMapping(value ="/search/domainList" ,method = RequestMethod.POST)
    public MessageResult searchDomainList(String domain,Integer pageNum,Integer pageSize){
        return exchangeService.searchDomainListByDomainName(domain,pageNum,pageSize);
    }

    /**
     * @param sourceId
     * @param visitId
     * @return
     */
    @RequestMapping(value = "/view/domain/detail",method = RequestMethod.POST)
    public MessageResult viewDomainDetail(Long sourceId,Long visitId) {
        return exchangeService.viewDomainDetail(sourceId,visitId);
    }

    /**
     * @param customerId
     * @param sourceId
     * @return
     */
    @RequestMapping(value = "/getSketch/ById",method = RequestMethod.POST)
    public String getSketchById(Long customerId,Long sourceId) {
        return exchangeService.getDomainScketchById(customerId,sourceId);
    }
}
