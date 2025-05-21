package com.scu.bpo.dao;

import com.scu.bpo.pojo.entity.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectDao {
    int deleteByPrimaryKey(Integer projectId);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer projectId);

    List<Project> selectPassed();

    List<Project> selectUnexamined();

    List<Project> selectByUserEmployerId(Integer userEmployerId);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

    int updateByProjectIdAndAdmin(Integer projectId,Integer projectAdminId,String status);

}
