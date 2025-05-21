package com.scu.bpo.dao;

import com.scu.bpo.pojo.entity.Cashflowdetail;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CashflowdetailDao {

    @Select("Select * from CashFlowDetail Order By Flow_ID")
    List<Cashflowdetail> SelectAll();
}