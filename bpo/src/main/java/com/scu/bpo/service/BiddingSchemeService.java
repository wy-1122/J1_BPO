package com.scu.bpo.service;

import com.scu.bpo.pojo.entity.BiddingScheme;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BiddingSchemeService {
    public boolean addNewBidding(BiddingScheme biddingScheme);
    public List<BiddingScheme> findBiddingScheme(Integer projectId);
    public BiddingScheme findSingleBidding(Integer projectId,Integer userEmployeeId);
}
