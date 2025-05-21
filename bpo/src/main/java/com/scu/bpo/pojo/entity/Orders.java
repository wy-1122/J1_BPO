package com.scu.bpo.pojo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * orders
 * @author 
 */
public class Orders implements Serializable {
    private Integer orderId;

    private Integer projectId;

    private Integer userEmployeeId;

    private Integer userEmployerId;

    private Date orderStartTime;

    private String orderState;

    private Float orderAmount;

    private Integer schedule;

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

    public Integer getUserEmployeeId() {
        return userEmployeeId;
    }

    public void setUserEmployeeId(Integer userEmployeeId) {
        this.userEmployeeId = userEmployeeId;
    }

    public Integer getUserEmployerId() {
        return userEmployerId;
    }

    public void setUserEmployerId(Integer userEmployerId) {
        this.userEmployerId = userEmployerId;
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

    public Integer getSchedule() {
        return schedule;
    }

    public void setSchedule(Integer schedule) {
        this.schedule = schedule;
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

    public Orders() {
    }

    public Orders(Integer projectId, Integer userEmployeeId, Integer userEmployerId, Date orderStartTime, String orderState, Float orderAmount, Integer schedule, Float employerDeposit, Float employeeDeposit) {
        this.projectId = projectId;
        this.userEmployeeId = userEmployeeId;
        this.userEmployerId = userEmployerId;
        this.orderStartTime = orderStartTime;
        this.orderState = orderState;
        this.orderAmount = orderAmount;
        this.schedule = schedule;
        this.employerDeposit = employerDeposit;
        this.employeeDeposit = employeeDeposit;
    }
}