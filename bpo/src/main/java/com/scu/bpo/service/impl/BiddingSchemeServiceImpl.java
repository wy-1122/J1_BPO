package com.scu.bpo.service.impl;

import com.scu.bpo.dao.BiddingSchemeDao;
import com.scu.bpo.pojo.entity.BiddingScheme;
import com.scu.bpo.service.BiddingSchemeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BiddingSchemeServiceImpl implements BiddingSchemeService {
    @Resource
    BiddingSchemeDao dao;

    @Override
    public boolean addNewBidding(BiddingScheme biddingScheme) {
        if(biddingScheme != null){
            int success = dao.insert2(biddingScheme);
            return true;
        }
        return false;
    }

    @Override
    public List<BiddingScheme> findBiddingScheme(Integer projectId) {
        List<BiddingScheme> biddingSchemeList = dao.selectByProjectId(projectId);
        return biddingSchemeList;

    }

    @Override
    public BiddingScheme findSingleBidding(Integer projectId, Integer userEmployeeId) {
        BiddingScheme biddingScheme = dao.selectSingleBidding(projectId, userEmployeeId);
        return biddingScheme;
    }

    public boolean updateStatus(Integer projectId,Integer userEmployeeId,Integer userEmployerId,String status){
        BiddingScheme biddingScheme = new BiddingScheme();
        biddingScheme.setProjectId(projectId);
        biddingScheme.setUserEmployeeId(userEmployeeId);
        biddingScheme.setUserEmployerId(userEmployerId);
        biddingScheme.setBiddingStatus(status);
        int rows = dao.updateByPrimaryKeySelective(biddingScheme);
        if (rows == 1) return true;
        return false;
    }
}
