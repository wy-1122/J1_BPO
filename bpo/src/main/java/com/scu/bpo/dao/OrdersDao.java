package com.scu.bpo.dao;

import com.scu.bpo.pojo.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrdersDao {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
}