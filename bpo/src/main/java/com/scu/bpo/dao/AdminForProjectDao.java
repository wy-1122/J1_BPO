package com.scu.bpo.dao;

import com.scu.bpo.pojo.entity.AdminForProject;
//import com.sun.org.glassfish.gmbal.ManagedObject;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminForProjectDao {
    int deleteByPrimaryKey(Integer userProjectAdminId);

    int insert(AdminForProject record);

    int insertSelective(AdminForProject record);

    AdminForProject selectByPrimaryKey(Integer userProjectAdminId);

    int updateByPrimaryKeySelective(AdminForProject record);

    int updateByPrimaryKey(AdminForProject record);
}
