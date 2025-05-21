package com.scu.bpo.service.impl;

import com.scu.bpo.dao.UserEmployeeDao;
import com.scu.bpo.pojo.entity.UserEmployee;
import com.scu.bpo.pojo.entity.UserEmployer;
import com.scu.bpo.service.UserEmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserEmployeeServiceImpl implements UserEmployeeService {
    @Resource
    UserEmployeeDao dao;

    @Override
    public int addNewEmployee(UserEmployee userEmployee) {
        int success = dao.insert2(userEmployee);
        return 0;
    }
}
