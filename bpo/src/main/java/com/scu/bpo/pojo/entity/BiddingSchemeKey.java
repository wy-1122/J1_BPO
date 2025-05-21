package com.scu.bpo.pojo.entity;

import java.io.Serializable;

/**
 * bidding_scheme
 * @author
 */
public class BiddingSchemeKey implements Serializable {
    private Integer userEmployeeId;

    private Integer projectId;

    private Integer userEmployerId;

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
}
