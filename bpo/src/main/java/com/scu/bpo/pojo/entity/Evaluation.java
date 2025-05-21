package com.scu.bpo.pojo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * evaluation
 * @author 
 */
public class Evaluation extends EvaluationKey implements Serializable {
    private Date evaluationTime;

    private String evaluationDetails;

    private static final long serialVersionUID = 1L;

    public Date getEvaluationTime() {
        return evaluationTime;
    }

    public void setEvaluationTime(Date evaluationTime) {
        this.evaluationTime = evaluationTime;
    }

    public String getEvaluationDetails() {
        return evaluationDetails;
    }

    public void setEvaluationDetails(String evaluationDetails) {
        this.evaluationDetails = evaluationDetails;
    }
}