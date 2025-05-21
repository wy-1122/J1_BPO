package com.scu.bpo.pojo.entity;

import java.io.Serializable;

/**
 * evaluation
 * @author 
 */
public class EvaluationKey implements Serializable {
    private Integer evaluationId;

    private Integer userRoleId;

    private Integer orderId;

    private static final long serialVersionUID = 1L;

    public Integer getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(Integer evaluationId) {
        this.evaluationId = evaluationId;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}