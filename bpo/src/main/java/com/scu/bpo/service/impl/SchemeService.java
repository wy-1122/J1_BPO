package com.scu.bpo.service.impl;

import com.scu.bpo.dao.SchemewithprojectnameDao;
import com.scu.bpo.pojo.entity.Schemewithprojectname;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchemeService {

    @Autowired
    SchemewithprojectnameDao schemewithprojectnameDao;

    public List<Schemewithprojectname> SelectByuserEmployeeId(Integer userEmployeeId){
        List<Schemewithprojectname> list = schemewithprojectnameDao.SelectByuserEmployeeId(userEmployeeId);
        return list;
    }

}
