package com.scu.bpo.dao;

import com.scu.bpo.pojo.entity.Evaluation;
import com.scu.bpo.pojo.entity.EvaluationKey;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EvaluationDao {
    int deleteByPrimaryKey(EvaluationKey key);

    int insert(Evaluation record);

    int insertSelective(Evaluation record);

    Evaluation selectByPrimaryKey(EvaluationKey key);

    int updateByPrimaryKeySelective(Evaluation record);

    int updateByPrimaryKey(Evaluation record);
}