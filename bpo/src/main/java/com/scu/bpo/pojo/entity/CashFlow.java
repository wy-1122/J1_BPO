package com.scu.bpo.pojo.entity;

import java.io.Serializable;

/**
 * cash_flow
 * @author 
 */
public class CashFlow implements Serializable {
    private Integer flowId;

    private Integer moneyId;

    private Integer moneyAdminId;

    private Integer orderTypeId;

    private Float openBalanceIncome;

    private Float openBalanceOutcome;

    private Float currentOccurenceAmountIncome;

    private Float currentOccurenceAmountOutcome;

    private Float accumulatedAmountIncome;

    private Float accumulatedAmountOutcome;

    private Float closingBalanceIncome;

    private Float closingBalanceOutcome;

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

    public Integer getMoneyAdminId() {
        return moneyAdminId;
    }

    public void setMoneyAdminId(Integer moneyAdminId) {
        this.moneyAdminId = moneyAdminId;
    }

    public Integer getOrderTypeId() {
        return orderTypeId;
    }

    public void setOrderTypeId(Integer orderTypeId) {
        this.orderTypeId = orderTypeId;
    }

    public Float getOpenBalanceIncome() {
        return openBalanceIncome;
    }

    public void setOpenBalanceIncome(Float openBalanceIncome) {
        this.openBalanceIncome = openBalanceIncome;
    }

    public Float getOpenBalanceOutcome() {
        return openBalanceOutcome;
    }

    public void setOpenBalanceOutcome(Float openBalanceOutcome) {
        this.openBalanceOutcome = openBalanceOutcome;
    }

    public Float getCurrentOccurenceAmountIncome() {
        return currentOccurenceAmountIncome;
    }

    public void setCurrentOccurenceAmountIncome(Float currentOccurenceAmountIncome) {
        this.currentOccurenceAmountIncome = currentOccurenceAmountIncome;
    }

    public Float getCurrentOccurenceAmountOutcome() {
        return currentOccurenceAmountOutcome;
    }

    public void setCurrentOccurenceAmountOutcome(Float currentOccurenceAmountOutcome) {
        this.currentOccurenceAmountOutcome = currentOccurenceAmountOutcome;
    }

    public Float getAccumulatedAmountIncome() {
        return accumulatedAmountIncome;
    }

    public void setAccumulatedAmountIncome(Float accumulatedAmountIncome) {
        this.accumulatedAmountIncome = accumulatedAmountIncome;
    }

    public Float getAccumulatedAmountOutcome() {
        return accumulatedAmountOutcome;
    }

    public void setAccumulatedAmountOutcome(Float accumulatedAmountOutcome) {
        this.accumulatedAmountOutcome = accumulatedAmountOutcome;
    }

    public Float getClosingBalanceIncome() {
        return closingBalanceIncome;
    }

    public void setClosingBalanceIncome(Float closingBalanceIncome) {
        this.closingBalanceIncome = closingBalanceIncome;
    }

    public Float getClosingBalanceOutcome() {
        return closingBalanceOutcome;
    }

    public void setClosingBalanceOutcome(Float closingBalanceOutcome) {
        this.closingBalanceOutcome = closingBalanceOutcome;
    }
}