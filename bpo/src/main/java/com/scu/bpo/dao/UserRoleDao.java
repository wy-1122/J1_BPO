package com.scu.bpo.dao;

import com.scu.bpo.pojo.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRoleDao {
    int deleteByPrimaryKey(Integer userRoleId);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer userRoleId);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    UserRole selectByUserIdAndRoleId(@Param("userId")Integer userId,@Param("roleId") Integer RoleId);
}
