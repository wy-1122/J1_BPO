package com.scu.bpo.pojo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * OrderWithContact
 * @author 
 */
public class Orderwithcontact implements Serializable {
    private Integer orderId;

    private Integer projectId;

    private Integer userEmployerId;

    private Integer userEmployeeId;

    private String projectName;

    private String connectName;

    private String connectTel;

    private String userEmployeeName;

    private String userEmployeeTel;

    private Integer schedule;

    private Date orderStartTime;

    private String orderState;

    private Float orderAmount;

    private Float employerDeposit;

    private Float employeeDeposit;

    private static final long serialVersionUID = 1L;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public Integer getUserEmployeeId() {
        return userEmployeeId;
    }

    public void setUserEmployeeId(Integer userEmployeeId) {
        this.userEmployeeId = userEmployeeId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getConnectName() {
        return connectName;
    }

    public void setConnectName(String connectName) {
        this.connectName = connectName;
    }

    public String getConnectTel() {
        return connectTel;
    }

    public void setConnectTel(String connectTel) {
        this.connectTel = connectTel;
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

    public Integer getSchedule() {
        return schedule;
    }

    public void setSchedule(Integer schedule) {
        this.schedule = schedule;
    }

    public Date getOrderStartTime() {
        return orderStartTime;
    }

    public void setOrderStartTime(Date orderStartTime) {
        this.orderStartTime = orderStartTime;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public Float getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Float orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Float getEmployerDeposit() {
        return employerDeposit;
    }

    public void setEmployerDeposit(Float employerDeposit) {
        this.employerDeposit = employerDeposit;
    }

    public Float getEmployeeDeposit() {
        return employeeDeposit;
    }

    public void setEmployeeDeposit(Float employeeDeposit) {
        this.employeeDeposit = employeeDeposit;
    }
}