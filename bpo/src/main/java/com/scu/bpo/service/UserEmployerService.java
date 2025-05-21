package com.scu.bpo.service;

import com.scu.bpo.pojo.entity.UserEmployer;
import org.springframework.stereotype.Service;

@Service
public interface UserEmployerService {
    public UserEmployer findEmployer(Integer userEmployerId);
    public int addNewEmployer(UserEmployer userEmployer);
}
