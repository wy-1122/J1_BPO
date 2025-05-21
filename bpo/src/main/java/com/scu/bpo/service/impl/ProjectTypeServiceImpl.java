package com.scu.bpo.service.impl;

import com.scu.bpo.dao.ProjectTypeDao;
import com.scu.bpo.service.ProjectTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProjectTypeServiceImpl implements ProjectTypeService {
    @Resource
    ProjectTypeDao dao;
    @Override
    public String findProjectTypeName(Integer projectTypeId) {
        String projectTypeName = dao.selectByPrimaryKey(projectTypeId).getProjectTypeName();
        return projectTypeName;
    }
}
