package com.scu.bpo.dao;

import com.scu.bpo.pojo.entity.ClientSupport;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Mapper
public interface ClientSupportDao {
    int deleteByPrimaryKey(Integer equipmentId);

    int insert(ClientSupport record);

    int insertSelective(ClientSupport record);

    ClientSupport selectByPrimaryKey(Integer equipmentId);

    int updateByPrimaryKeySelective(ClientSupport record);

    int updateByPrimaryKey(ClientSupport record);
}
