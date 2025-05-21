package com.scu.bpo.pojo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * money_notification
 * @author 
 */
public class MoneyNotification implements Serializable {
    private Integer moneyId;

    private Integer orderId;

    private Integer orderAdminId;

    private Date moneyTime;

    private Float amount;

    private String moneyType;

    private Integer userId;

    private String moneyDescription;

    private static final long serialVersionUID = 1L;

    public Integer getMoneyId() {
        return moneyId;
    }

    public void setMoneyId(Integer moneyId) {
        this.moneyId = moneyId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderAdminId() {
        return orderAdminId;
    }

    public void setOrderAdminId(Integer orderAdminId) {
        this.orderAdminId = orderAdminId;
    }

    public Date getMoneyTime() {
        return moneyTime;
    }

    public void setMoneyTime(Date moneyTime) {
        this.moneyTime = moneyTime;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMoneyDescription() {
        return moneyDescription;
    }

    public void setMoneyDescription(String moneyDescription) {
        this.moneyDescription = moneyDescription;
    }
}