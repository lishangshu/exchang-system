package com.fuxi.dao;

import com.fuxi.entity.CustomerPurchaseRecord;
import com.fuxi.entity.CustomerPurchaseRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerPurchaseRecordMapper {
    int countByExample(CustomerPurchaseRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustomerPurchaseRecord record);

    int insertSelective(CustomerPurchaseRecord record);

    List<CustomerPurchaseRecord> selectByExample(CustomerPurchaseRecordExample example);

    CustomerPurchaseRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustomerPurchaseRecord record, @Param("example") CustomerPurchaseRecordExample example);

    int updateByExample(@Param("record") CustomerPurchaseRecord record, @Param("example") CustomerPurchaseRecordExample example);

    int updateByPrimaryKeySelective(CustomerPurchaseRecord record);

    int updateByPrimaryKey(CustomerPurchaseRecord record);
}