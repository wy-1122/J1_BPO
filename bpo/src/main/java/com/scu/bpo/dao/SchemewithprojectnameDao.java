package com.scu.bpo.dao;

import com.scu.bpo.pojo.entity.Schemewithprojectname;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface SchemewithprojectnameDao {

    @Select("Select * from SchemeWithProjectName Where User_Employee_ID=#{userEmployeeId}")
    List<Schemewithprojectname> SelectByuserEmployeeId(Integer userEmployeeId);
}