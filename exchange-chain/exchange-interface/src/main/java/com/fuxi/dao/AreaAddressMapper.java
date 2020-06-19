package com.fuxi.dao;

import com.fuxi.entity.AreaAddress;
import com.fuxi.entity.AreaAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AreaAddressMapper {
    int countByExample(AreaAddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AreaAddress record);

    int insertSelective(AreaAddress record);

    List<AreaAddress> selectByExample(AreaAddressExample example);

    AreaAddress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AreaAddress record, @Param("example") AreaAddressExample example);

    int updateByExample(@Param("record") AreaAddress record, @Param("example") AreaAddressExample example);

    int updateByPrimaryKeySelective(AreaAddress record);

    int updateByPrimaryKey(AreaAddress record);
}