package com.fuxi.bridge.service.Impl;

import com.fuxi.bridge.entity.TransactionLog;
import com.fuxi.bridge.entity.TransactionLogExample;
import com.fuxi.bridge.dao.TransactionLogMapper;
import com.fuxi.bridge.entity.TransactionLog;
import com.fuxi.bridge.entity.TransactionLogExample;
import com.fuxi.bridge.pojo.Result;
import com.fuxi.bridge.service.TransactionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Laker
 * @Date: 2020/5/28 11:41
 * @Description:
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionLogMapper transactionLogMapper;

    /**
     *
     * @param transactionLog
     * @return
     */
    @Override
    public int insertSelective(TransactionLog transactionLog) {
        return transactionLogMapper.insertSelective(transactionLog);
    }

    @Override
    public boolean isRepetRecord(TransactionLog transactionLog) {
        TransactionLogExample tle = new TransactionLogExample();
        TransactionLogExample.Criteria criteria = tle.createCriteria();
        criteria.andBlockNumberEqualTo(transactionLog.getBlockNumber());
        criteria.andTransactionIndexEqualTo(transactionLog.getTransactionIndex());
        criteria.andLogIndexEqualTo(transactionLog.getLogIndex());
        return transactionLogMapper.countByExample(tle)>0?true:false;
    }

    /**
     *  Get my transcation list (include in and out)
     * @param address
     * @param pageNum
     * @param pageSize
     * @return 主要属性
     */
    @Override
    public Result getMyTransactionList(String address, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<TransactionLog> result = new PageInfo<>(transactionLogMapper.selectByMainElem(address));
        return Result.success(result);
    }
}
