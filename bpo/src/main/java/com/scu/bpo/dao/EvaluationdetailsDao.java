package com.scu.bpo.dao;

import com.scu.bpo.pojo.entity.Evaluation;
import com.scu.bpo.pojo.entity.Evaluationdetails;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface EvaluationdetailsDao {

    @Select("Select * from EvaluationDetails Where User_Role_Id = #{UserRoleId}")
    List<Evaluationdetails> SelectByUserRoleId(Integer UserRoleId);
}