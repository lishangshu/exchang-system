package com.fuxi.dao;

import com.fuxi.entity.ExchangeDomain;
import com.fuxi.entity.ExchangeDomainExample;
import java.util.List;
import java.util.Map;

import com.fuxi.pojo.ExchangeDomainVo;
import org.apache.ibatis.annotations.Param;

public interface ExchangeDomainMapper {
    int countByExample(ExchangeDomainExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ExchangeDomain record);

    int insertSelective(ExchangeDomain record);

    List<ExchangeDomain> selectByExampleWithBLOBs(ExchangeDomainExample example);

    List<ExchangeDomain> selectByExample(ExchangeDomainExample example);

    ExchangeDomain selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ExchangeDomain record, @Param("example") ExchangeDomainExample example);

    int updateByExampleWithBLOBs(@Param("record") ExchangeDomain record, @Param("example") ExchangeDomainExample example);

    int updateByExample(@Param("record") ExchangeDomain record, @Param("example") ExchangeDomainExample example);

    int updateByPrimaryKeySelective(ExchangeDomain record);

    int updateByPrimaryKeyWithBLOBs(ExchangeDomain record);

    int updateByPrimaryKey(ExchangeDomain record);

    List<Map<String,Object>> selectDomainSimpleList(@Param("domain") String domain, @Param("logicalDel") Byte logicalDel, @Param("status") Boolean status);

    ExchangeDomainVo findExchangeDomainAndPublisherById(Long id);

    Map<String,Object> selectWhoIsById(Long id);
}