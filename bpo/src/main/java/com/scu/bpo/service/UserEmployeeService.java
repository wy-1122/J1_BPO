package com.scu.bpo.service;

import com.scu.bpo.pojo.entity.UserEmployee;
import com.scu.bpo.pojo.entity.UserEmployer;
import org.springframework.stereotype.Service;

@Service
public interface UserEmployeeService {
    public int addNewEmployee(UserEmployee userEmployee);
}
