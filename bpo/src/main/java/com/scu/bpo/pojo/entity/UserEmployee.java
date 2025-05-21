package com.scu.bpo.pojo.entity;

import java.io.Serializable;

/**
 * user_employee
 * @author 
 */
public class UserEmployee implements Serializable {
    private Integer userEmployeeId;

    private static final long serialVersionUID = 1L;

    public Integer getUserEmployeeId() {
        return userEmployeeId;
    }

    public void setUserEmployeeId(Integer userEmployeeId) {
        this.userEmployeeId = userEmployeeId;
    }
}