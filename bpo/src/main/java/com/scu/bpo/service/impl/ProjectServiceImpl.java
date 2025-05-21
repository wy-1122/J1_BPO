package com.scu.bpo.service.impl;

import com.scu.bpo.dao.ProjectDao;
import com.scu.bpo.pojo.entity.Project;
import com.scu.bpo.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Resource
    ProjectDao dao;

    @Override
    public boolean addNewProject(Project project) {
        //获得返回值
        int key = dao.insertSelective(project);
        if(key!=0){
            return true;
        }
        return false;
    }

    @Override
    public List<Project> selectPassedProject() {
        List<Project> projectList = new ArrayList<>();
        projectList = dao.selectPassed();
        return projectList;
    }

    @Override
    public List<Project> selectUnexaminedProject() {
        List<Project> projectList = new ArrayList<>();
        Project project = new Project();
        projectList = dao.selectUnexamined();
        return projectList;
    }

    @Override
    public Project selectProjectByKey(Integer projectId) {
        Project project = dao.selectByPrimaryKey(projectId);
        return project;
    }

    @Override
    public Integer examinePassed(Integer projectId, Integer projectAdminId) {
        int success = dao.updateByProjectIdAndAdmin(projectId,projectAdminId,"已通过");
        return success;
    }

    @Override
    public Integer examineRefused(Integer projectId, Integer projectAdminId) {
        int success = dao.updateByProjectIdAndAdmin(projectId,projectAdminId,"未通过");
        return success;
    }

    @Override
    public List<Project> selectProjectByUserEmployerId(Integer userEmployerId) {
        List<Project> projectList = new ArrayList<>();
        projectList = dao.selectByUserEmployerId(userEmployerId);
        return projectList;
    }

    @Override
    public boolean UpdateProjectType(Integer projectId,String Status){
        Project tmp = new Project();
        tmp.setProjectId(projectId);
        tmp.setProjectStatus(Status);
        Integer rows = dao.updateByPrimaryKeySelective(tmp);
        if (rows == 1) return true;
        else return false;
    }
}
