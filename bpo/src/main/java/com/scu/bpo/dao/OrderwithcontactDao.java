package com.scu.bpo.dao;

import com.scu.bpo.pojo.entity.Orderwithcontact;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderwithcontactDao {

    @Select("Select * From OrderWithContact Where User_Employer_ID = #{userEmployerId}")
    List<Orderwithcontact> SelectByuserEmployerId(Integer userEmployerId);

    @Select("Select * From OrderWithContact Where User_Employee_ID = #{userEmployeeId}")
    List<Orderwithcontact> SelectByuserEmployeeId(Integer userEmployeeId);

    @Select("Select * From OrderWithContact Where Order_ID = #{orderId}")
    Orderwithcontact SelectByOrderId(Integer orderId);
}