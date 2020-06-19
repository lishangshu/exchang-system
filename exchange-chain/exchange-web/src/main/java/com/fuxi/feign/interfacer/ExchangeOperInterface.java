package com.fuxi.feign.interfacer;

import com.fuxi.dto.MessageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Auther: Laker
 * @Date: 2020/5/26 14:26
 * @Description:
 */
@FeignClient(value = "customer-center-exchange")
public interface ExchangeOperInterface {

    @RequestMapping(value = "/exchange/upload/chain",method = RequestMethod.POST)
    public MessageResult customeUploadData2Chain(@RequestParam("exchangeDomainJson") String exchangeDomainJson);

    @RequestMapping(value = "/exchange/publish/record",method = RequestMethod.POST)
    MessageResult findCustomePublishRecord(@RequestParam("customerId") Long customerId, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);

    @RequestMapping(value = "/exchange/search/domainList",method = RequestMethod.POST)
    MessageResult searchDomainList(@RequestParam("domain") String domain, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);

    @RequestMapping(value = "/exchange/view/domain/detail",method = RequestMethod.POST)
    MessageResult viewExchangeDomainDetail(@RequestParam("sourceId") Long sourceId, @RequestParam("visitId") Long visitId);

    @RequestMapping(value = "/exchange/getSketch/ById",method = RequestMethod.POST)
    String getDomainSketchById(@RequestParam("customerId") Long customerId, @RequestParam("sourceId") Long sourceId);
}
