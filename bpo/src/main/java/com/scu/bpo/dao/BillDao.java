package com.scu.bpo.dao;

import com.scu.bpo.pojo.entity.Bill;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BillDao {
    int deleteByPrimaryKey(Integer billId);

    int insert(Bill record);

    int insertSelective(Bill record);

    Bill selectByPrimaryKey(Integer billId);

    int updateByPrimaryKeySelective(Bill record);

    int updateByPrimaryKey(Bill record);

    @Select("Select * From bill Where User_ID = #{UserId} Order By Bill_Time")
    List<Bill> SelectByUserId(Integer UserId);
}