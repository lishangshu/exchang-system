package com.fuxi.bridge.service;

import com.fuxi.bridge.pojo.Result;

/**
 * @Auther: Laker
 * @Date: 2020/5/26 17:05
 * @Description:
 */
public interface ExchangeService {


    Result depositData2Chain(String domainHash, String contentHash, String address) throws Exception;

    Result getMyScore(String address) throws Exception;

    Result uploadData2Chain(String domainHash, String digestHash, String accountAddress);

    Result visitDomainDigestHashCode(String domainHash, String sourceAddress, String visitorAddress) throws Exception;
}
