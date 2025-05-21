package com.scu.bpo.service.impl;

import com.scu.bpo.dao.BillDao;
import com.scu.bpo.pojo.entity.Bill;
import com.scu.bpo.pojo.entity.MoneyNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {
    @Autowired
    BillDao billDao;

    public List<Bill> SelectByUserId(Integer UserId){
        List<Bill> bills = billDao.SelectByUserId(UserId);
        return bills;
    }

//    用户账单添加支付定金记录
    public boolean AddNewBill(MoneyNotification notification){
        Bill bill = new Bill();
        bill.setUserId(notification.getUserId());
        bill.setBillValue(notification.getAmount());
        bill.setBillType(notification.getMoneyType());
        bill.setBillTime(notification.getMoneyTime());
        bill.setBillDescription(notification.getMoneyDescription());
        billDao.insert(bill);
        return false;
    }
}
