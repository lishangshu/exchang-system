package com.fuxi.service;

import com.fuxi.dto.MessageResult;

/**
 * @Auther: Laker
 * @Date: 2020/5/26 14:20
 * @Description:
 */
public interface ExchangeService {

    public MessageResult customUploadData2Chain(String submitInfoJson) throws Exception;

    void initAccountAddress(String userCode);

    MessageResult acquireMyAccount(Long customerId);

    MessageResult acquireMyTransactionList(Long customerId, Integer pageNum, Integer pageSize);

    MessageResult findCustomePublishRecord(Long customerId, Integer pageNum, Integer pageSize);

    MessageResult searchDomainListByDomainName(String domain, Integer pageNum, Integer pageSize);

    MessageResult viewDomainDetail(Long sourceId, Long visitId);

    String getDomainScketchById(Long id, Long sourceId);
}
