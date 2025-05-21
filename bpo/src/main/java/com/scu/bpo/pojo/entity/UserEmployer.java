package com.scu.bpo.pojo.entity;

import java.io.Serializable;

/**
 * User_Employer
 * @author 
 */
public class UserEmployer implements Serializable {
    private Integer userEmployerId;

    private String userEmployerName;

    private String userEmployerRegion;

    private String userEmployerInctroduction;

    private String userEmployerTel;

    private static final long serialVersionUID = 1L;

    public Integer getUserEmployerId() {
        return userEmployerId;
    }

    public void setUserEmployerId(Integer userEmployerId) {
        this.userEmployerId = userEmployerId;
    }

    public String getUserEmployerName() {
        return userEmployerName;
    }

    public void setUserEmployerName(String userEmployerName) {
        this.userEmployerName = userEmployerName;
    }

    public String getUserEmployerRegion() {
        return userEmployerRegion;
    }

    public void setUserEmployerRegion(String userEmployerRegion) {
        this.userEmployerRegion = userEmployerRegion;
    }

    public String getUserEmployerInctroduction() {
        return userEmployerInctroduction;
    }

    public void setUserEmployerInctroduction(String userEmployerInctroduction) {
        this.userEmployerInctroduction = userEmployerInctroduction;
    }

    public String getUserEmployerTel() {
        return userEmployerTel;
    }

    public void setUserEmployerTel(String userEmployerTel) {
        this.userEmployerTel = userEmployerTel;
    }
}