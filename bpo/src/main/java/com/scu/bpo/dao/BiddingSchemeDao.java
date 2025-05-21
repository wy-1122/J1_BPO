package com.scu.bpo.dao;

import com.scu.bpo.pojo.entity.BiddingScheme;
import com.scu.bpo.pojo.entity.BiddingSchemeKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BiddingSchemeDao {
    int deleteByPrimaryKey(BiddingSchemeKey key);

    int insert(BiddingScheme record);

    int insert2(BiddingScheme record);

    int insertSelective(BiddingScheme record);

    BiddingScheme selectByPrimaryKey(BiddingSchemeKey key);

    BiddingScheme selectSingleBidding(Integer projectId,Integer userEmployeeId);

    List<BiddingScheme> selectByProjectId(Integer projectId);

    int updateByPrimaryKeySelective(BiddingScheme record);

    int updateByPrimaryKey(BiddingScheme record);
}
