package com.scu.bpo.pojo.entity;

import java.io.Serializable;

/**
 * SchemeWithProjectName
 * @author 
 */
public class Schemewithprojectname implements Serializable {
    private Integer userEmployeeId;

    private Integer projectId;

    private Integer userEmployerId;

    private String projectPeriod;

    private String projectAmout;

    private String projectSuperiority;

    private String biddingExample;

    private String userEmployeeName;

    private String userEmployeeTel;

    private String biddingStatus;

    private String projectName;

    private static final long serialVersionUID = 1L;

    public Integer getUserEmployeeId() {
        return userEmployeeId;
    }

    public void setUserEmployeeId(Integer userEmployeeId) {
        this.userEmployeeId = userEmployeeId;
    }

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

    public String getProjectPeriod() {
        return projectPeriod;
    }

    public void setProjectPeriod(String projectPeriod) {
        this.projectPeriod = projectPeriod;
    }

    public String getProjectAmout() {
        return projectAmout;
    }

    public void setProjectAmout(String projectAmout) {
        this.projectAmout = projectAmout;
    }

    public String getProjectSuperiority() {
        return projectSuperiority;
    }

    public void setProjectSuperiority(String projectSuperiority) {
        this.projectSuperiority = projectSuperiority;
    }

    public String getBiddingExample() {
        return biddingExample;
    }

    public void setBiddingExample(String biddingExample) {
        this.biddingExample = biddingExample;
    }

    public String getUserEmployeeName() {
        return userEmployeeName;
    }

    public void setUserEmployeeName(String userEmployeeName) {
        this.userEmployeeName = userEmployeeName;
    }

    public String getUserEmployeeTel() {
        return userEmployeeTel;
    }

    public void setUserEmployeeTel(String userEmployeeTel) {
        this.userEmployeeTel = userEmployeeTel;
    }

    public String getBiddingStatus() {
        return biddingStatus;
    }

    public void setBiddingStatus(String biddingStatus) {
        this.biddingStatus = biddingStatus;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}