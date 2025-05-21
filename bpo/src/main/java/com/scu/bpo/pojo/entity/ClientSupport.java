package com.scu.bpo.pojo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * client_support
 * @author
 */
@Data
public class ClientSupport implements Serializable {
    private Integer equipmentId;

    private String equipmentName;

    private static final long serialVersionUID = 1L;

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }
}
