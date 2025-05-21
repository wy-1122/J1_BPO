package com.scu.bpo.service.impl;

import com.scu.bpo.dao.ClientSupportDao;
import com.scu.bpo.pojo.entity.ClientSupport;
import com.scu.bpo.service.ClientSupportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ClientSupportServiceImpl implements ClientSupportService {
    @Resource
    ClientSupportDao dao;
    @Override
    public String getEquipmentName(Integer equipmentId) {
        String equipmentName = dao.selectByPrimaryKey(equipmentId).getEquipmentName();
        return equipmentName;
    }
}
