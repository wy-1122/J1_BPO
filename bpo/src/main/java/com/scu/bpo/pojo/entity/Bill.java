package com.scu.bpo.pojo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * bill
 * @author 
 */
public class Bill implements Serializable {
    private Integer billId;

    private Integer userId;

    private Float billValue;

    private String billType;

    private Date billTime;

    private String billDescription;

    private static final long serialVersionUID = 1L;

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Float getBillValue() {
        return billValue;
    }

    public void setBillValue(Float billValue) {
        this.billValue = billValue;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public Date getBillTime() {
        return billTime;
    }

    public void setBillTime(Date billTime) {
        this.billTime = billTime;
    }

    public String getBillDescription() {
        return billDescription;
    }

    public void setBillDescription(String billDescription) {
        this.billDescription = billDescription;
    }
}