package com.scu.bpo.dao;

import com.scu.bpo.pojo.entity.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Select("Select * from User Where User_Name=#{userName}")
    User selectByUserName(String userName);
}