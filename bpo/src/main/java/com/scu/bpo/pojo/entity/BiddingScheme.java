package com.scu.bpo.pojo.entity;

import java.io.Serializable;

/**
 * bidding_scheme
 * @author
 */
public class BiddingScheme extends BiddingSchemeKey implements Serializable {
    private String projectPeriod;

    private String projectAmout;

    private String projectSuperiority;

    private String biddingExample;

    private String userEmployeeName;

    private String userEmployeeTel;

    private String biddingStatus;

    private static final long serialVersionUID = 1L;

    public String getProjectPeriod() {
        return projectPeriod;
    }

    public void setProjectPeriod(String projectPeriod) {
        this.projectPeriod = projectPeriod;
    }

    public String getProjectAmout() {
        return projectAmout;
    }

    public void setProjectAmout(String projectAmout) {
        this.projectAmout = projectAmout;
    }

    public String getProjectSuperiority() {
        return projectSuperiority;
    }

    public void setProjectSuperiority(String projectSuperiority) {
        this.projectSuperiority = projectSuperiority;
    }

    public String getBiddingExample() {
        return biddingExample;
    }

    public void setBiddingExample(String biddingExample) {
        this.biddingExample = biddingExample;
    }

    public String getUserEmployeeName() {
        return userEmployeeName;
    }

    public void setUserEmployeeName(String userEmployeeName) {
        this.userEmployeeName = userEmployeeName;
    }

    public String getUserEmployeeTel() {
        return userEmployeeTel;
    }

    public void setUserEmployeeTel(String userEmployeeTel) {
        this.userEmployeeTel = userEmployeeTel;
    }

    public String getBiddingStatus() {
        return biddingStatus;
    }

    public void setBiddingStatus(String biddingStatus) {
        this.biddingStatus = biddingStatus;
    }
}
