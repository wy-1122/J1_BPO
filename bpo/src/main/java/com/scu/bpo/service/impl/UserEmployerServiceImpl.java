package com.scu.bpo.service.impl;

import com.scu.bpo.dao.UserEmployerDao;
import com.scu.bpo.pojo.entity.User;
import com.scu.bpo.pojo.entity.UserEmployer;
import com.scu.bpo.service.UserEmployerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserEmployerServiceImpl implements UserEmployerService {
    @Resource
    UserEmployerDao dao;
    @Override
    public UserEmployer findEmployer(Integer userEmployerId) {
        UserEmployer userEmployer = dao.selectByPrimaryKey(userEmployerId);
        return userEmployer;
    }

    @Override
    public int addNewEmployer(UserEmployer userEmployer) {

        int success = dao.insert2(userEmployer);
        return 0;
    }

}
