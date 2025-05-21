package com.scu.bpo.service.impl;

import com.scu.bpo.dao.UserRoleDao;
import com.scu.bpo.pojo.entity.UserRole;
import com.scu.bpo.service.UserRoleService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Resource
    UserRoleDao dao;

    @Override
    public boolean addNewUserRole(Integer userId) {
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);

        userRole.setRoleId(1);
        int employer = dao.insert(userRole);
        userRole.setRoleId(2);
        int employee = dao.insert(userRole);
        if(employee != 0 && employer != 0){
            return true;
        }
        return false;
    }

    @Override
    public UserRole findUserRoleEmployer(Integer userId){
        UserRole userRole = new UserRole();

        userRole = dao.selectByUserIdAndRoleId(userId,1);
        return userRole;
    }

    @Override
    public UserRole findUserRoleEmployee(Integer userId) {
        UserRole userRole = new UserRole();

        userRole = dao.selectByUserIdAndRoleId(userId,2);
        return userRole;
    }

    @Override
    public UserRole findProjectAdmin(Integer userId) {
        UserRole userRole = new UserRole();
        userRole = dao.selectByUserIdAndRoleId(userId,3);
        return userRole;
    }

    public UserRole SelectByUserRoleId(Integer userRoleId){
        UserRole userRole = dao.selectByPrimaryKey(userRoleId);
        return userRole;
    }
}
