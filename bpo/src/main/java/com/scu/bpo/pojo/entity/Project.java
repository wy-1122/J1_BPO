package com.scu.bpo.pojo.entity;

import java.io.Serializable;

/**
 * project
 * @author
 */
public class Project implements Serializable {
    private Integer projectId;

    private Integer userEmployerId;

    private String equipmentId;

    private Integer projectTypeId;

    private Integer projectAdminId;

    private String projectName;

    private String skillsRequirement;

    private String projectRequirement;

    private String projectPeriod;

    private String projectBudget;

    private String projectStatus;

    private String connectTel;

    private String connectName;

    private static final long serialVersionUID = 1L;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getUserEmployerId() {
        return userEmployerId;
    }

    public void setUserEmployerId(Integer userEmployerId) {
        this.userEmployerId = userEmployerId;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Integer getProjectTypeId() {
        return projectTypeId;
    }

    public void setProjectTypeId(Integer projectTypeId) {
        this.projectTypeId = projectTypeId;
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
}
