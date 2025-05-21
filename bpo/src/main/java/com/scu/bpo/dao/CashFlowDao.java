package com.scu.bpo.dao;

import com.scu.bpo.pojo.entity.CashFlow;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CashFlowDao {
    int deleteByPrimaryKey(Integer flowId);

    int insert(CashFlow record);

    int insertSelective(CashFlow record);

    CashFlow selectByPrimaryKey(Integer flowId);

    int updateByPrimaryKeySelective(CashFlow record);

    int updateByPrimaryKey(CashFlow record);

    @Select("SELECT * FROM cash_flow order by Flow_ID desc limit 1")
    CashFlow SelectTopRecord();
}