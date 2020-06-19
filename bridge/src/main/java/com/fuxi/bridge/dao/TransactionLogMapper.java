package com.fuxi.bridge.dao;

import com.fuxi.bridge.entity.TransactionLog;
import com.fuxi.bridge.entity.TransactionLogExample;
import com.fuxi.bridge.entity.TransactionLog;
import com.fuxi.bridge.entity.TransactionLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransactionLogMapper {
    int countByExample(TransactionLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TransactionLog record);

    int insertSelective(TransactionLog record);

    List<TransactionLog> selectByExampleWithBLOBs(TransactionLogExample example);

    List<TransactionLog> selectByExample(TransactionLogExample example);

    TransactionLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TransactionLog record, @Param("example") TransactionLogExample example);

    int updateByExampleWithBLOBs(@Param("record") TransactionLog record, @Param("example") TransactionLogExample example);

    int updateByExample(@Param("record") TransactionLog record, @Param("example") TransactionLogExample example);

    int updateByPrimaryKeySelective(TransactionLog record);

    int updateByPrimaryKeyWithBLOBs(TransactionLog record);

    int updateByPrimaryKey(TransactionLog record);

    List<TransactionLog> selectByMainElem(String address);
}