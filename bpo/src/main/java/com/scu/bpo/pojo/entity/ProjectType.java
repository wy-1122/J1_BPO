package com.scu.bpo.pojo.entity;

import java.io.Serializable;

/**
 * Project_Type
 * @author 
 */
public class ProjectType implements Serializable {
    private Integer projectTypeId;

    private String projectTypeName;

    private static final long serialVersionUID = 1L;

    public Integer getProjectTypeId() {
        return projectTypeId;
    }

    public void setProjectTypeId(Integer projectTypeId) {
        this.projectTypeId = projectTypeId;
    }

    public String getProjectTypeName() {
        return projectTypeName;
    }

    public void setProjectTypeName(String projectTypeName) {
        this.projectTypeName = projectTypeName;
    }
}