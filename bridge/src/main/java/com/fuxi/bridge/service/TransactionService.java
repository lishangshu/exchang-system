package com.fuxi.bridge.service;

import com.fuxi.bridge.entity.TransactionLog;
import com.fuxi.bridge.entity.TransactionLog;
import com.fuxi.bridge.pojo.Result;

/**
 * @Auther: Laker
 * @Date: 2020/5/28 11:41
 * @Description:
 */
public interface TransactionService {

    int insertSelective(TransactionLog transactionLog);

    boolean isRepetRecord(TransactionLog transactionLog);

    /**
     * @param address
     * @param pageNum
     * @param pageSize
     * @return
     */
    Result getMyTransactionList(String address, Integer pageNum, Integer pageSize);
}
