package com.scu.bpo.dao;

import com.scu.bpo.pojo.entity.Employee;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeDao {

    @Select("Select * from Employee where User_Employee_ID=#{userEmployeeId}")
    Employee SelectById(Integer userEmployeeId);

}