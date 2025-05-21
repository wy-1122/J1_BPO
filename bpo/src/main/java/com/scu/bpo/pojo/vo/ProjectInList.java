package com.scu.bpo.pojo.vo;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;

/**
 * project
 * @author
 */

@Mapper
public class ProjectInList implements Serializable {
    public Integer projectId;

    public String userEmployerName;

    public String equipmentName;

    public String projectType;

    public Integer projectAdminId;

    public String projectName;

    public String skillsRequirement;

    public String projectRequirement;

    public String projectPeriod;

    public String projectBudget;

    public String projectStatus;

    public String connectTel;

    public String connectName;

    public static final long serialVersionUID = 1L;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getUserEmployerName() {
        return userEmployerName;
    }

    public void setUserEmployerName(String userEmployerName) {
        this.userEmployerName = userEmployerName;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public Integer getProjectAdminId() {
        return projectAdminId;
    }

    public void setProjectAdminId(Integer projectAdminId) {
        this.projectAdminId = projectAdminId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getSkillsRequirement() {
        return skillsRequirement;
    }

    public void setSkillsRequirement(String skillsRequirement) {
        this.skillsRequirement = skillsRequirement;
    }

    public String getProjectRequirement() {
        return projectRequirement;
    }

    public void setProjectRequirement(String projectRequirement) {
        this.projectRequirement = projectRequirement;
    }

    public String getProjectPeriod() {
        return projectPeriod;
    }

    public void setProjectPeriod(String projectPeriod) {
        this.projectPeriod = projectPeriod;
    }

    public String getProjectBudget() {
        return projectBudget;
    }

    public void setProjectBudget(String projectBudget) {
        this.projectBudget = projectBudget;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getConnectTel() {
        return connectTel;
    }

    public void setConnectTel(String connectTel) {
        this.connectTel = connectTel;
    }

    public String getConnectName() {
        return connectName;
    }

    public void setConnectName(String connectName) {
        this.connectName = connectName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
