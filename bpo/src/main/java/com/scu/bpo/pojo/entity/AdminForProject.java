package com.scu.bpo.pojo.entity;

import java.io.Serializable;

/**
 * Admin_For_Project
 * @author 
 */
public class AdminForProject implements Serializable {
    private Integer userProjectAdminId;

    private String projectAdminName;

    private static final long serialVersionUID = 1L;

    public Integer getUserProjectAdminId() {
        return userProjectAdminId;
    }

    public void setUserProjectAdminId(Integer userProjectAdminId) {
        this.userProjectAdminId = userProjectAdminId;
    }

    public String getProjectAdminName() {
        return projectAdminName;
    }

    public void setProjectAdminName(String projectAdminName) {
        this.projectAdminName = projectAdminName;
    }
}