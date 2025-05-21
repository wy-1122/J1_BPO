package com.scu.bpo.pojo.entity;

import java.io.Serializable;

/**
 * Employee
 * @author 
 */
public class Employee implements Serializable {
    private Integer userEmployeeId;

    private String employeeName;

    private String employeeRegion;

    private String employeeEnterprise;

    private String employeeSelfIntroduction;

    private String employeePhone;

    private static final long serialVersionUID = 1L;

    public Integer getUserEmployeeId() {
        return userEmployeeId;
    }

    public void setUserEmployeeId(Integer userEmployeeId) {
        this.userEmployeeId = userEmployeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeRegion() {
        return employeeRegion;
    }

    public void setEmployeeRegion(String employeeRegion) {
        this.employeeRegion = employeeRegion;
    }

    public String getEmployeeEnterprise() {
        return employeeEnterprise;
    }

    public void setEmployeeEnterprise(String employeeEnterprise) {
        this.employeeEnterprise = employeeEnterprise;
    }

    public String getEmployeeSelfIntroduction() {
        return employeeSelfIntroduction;
    }

    public void setEmployeeSelfIntroduction(String employeeSelfIntroduction) {
        this.employeeSelfIntroduction = employeeSelfIntroduction;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }
}