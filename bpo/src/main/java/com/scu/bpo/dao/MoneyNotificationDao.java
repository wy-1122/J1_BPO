package com.scu.bpo.dao;

import com.scu.bpo.pojo.entity.MoneyNotification;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MoneyNotificationDao {
    int deleteByPrimaryKey(Integer moneyId);

    int insert(MoneyNotification record);

    int insertSelective(MoneyNotification record);

    MoneyNotification selectByPrimaryKey(Integer moneyId);

    int updateByPrimaryKeySelective(MoneyNotification record);

    int updateByPrimaryKey(MoneyNotification record);
}