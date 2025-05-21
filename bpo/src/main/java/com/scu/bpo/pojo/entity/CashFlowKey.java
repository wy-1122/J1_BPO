package com.scu.bpo.pojo.entity;

import java.io.Serializable;

/**
 * cash_flow
 * @author 
 */
public class CashFlowKey implements Serializable {
    private Integer flowId;

    private Integer moneyId;

    private static final long serialVersionUID = 1L;

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public Integer getMoneyId() {
        return moneyId;
    }

    public void setMoneyId(Integer moneyId) {
        this.moneyId = moneyId;
    }
}