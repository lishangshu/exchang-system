package com.fuxi.bridge.dao;

import com.fuxi.bridge.entity.AccountAddress;
import com.fuxi.bridge.entity.AccountAddressExample;
import com.fuxi.bridge.entity.AccountAddress;
import com.fuxi.bridge.entity.AccountAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountAddressMapper {
    int countByExample(AccountAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AccountAddress record);

    int insertSelective(AccountAddress record);

    List<AccountAddress> selectByExampleWithBLOBs(AccountAddressExample example);

    List<AccountAddress> selectByExample(AccountAddressExample example);

    AccountAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AccountAddress record, @Param("example") AccountAddressExample example);

    int updateByExampleWithBLOBs(@Param("record") AccountAddress record, @Param("example") AccountAddressExample example);

    int updateByExample(@Param("record") AccountAddress record, @Param("example") AccountAddressExample example);

    int updateByPrimaryKeySelective(AccountAddress record);

    int updateByPrimaryKeyWithBLOBs(AccountAddress record);

    int updateByPrimaryKey(AccountAddress record);
}