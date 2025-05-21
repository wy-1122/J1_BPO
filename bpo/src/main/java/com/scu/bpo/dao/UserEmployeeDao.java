package com.scu.bpo.dao;

import com.scu.bpo.pojo.entity.UserEmployee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserEmployeeDao {
    int deleteByPrimaryKey(Integer userEmployeeId);

    int insert(UserEmployee record);

    int insert2(UserEmployee record);

    int insertSelective(UserEmployee record);
}
