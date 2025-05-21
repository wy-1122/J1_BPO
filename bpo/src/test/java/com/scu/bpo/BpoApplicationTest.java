package com.scu.bpo;

import com.scu.bpo.dao.EmployeeDao;
import com.scu.bpo.dao.MoneyNotificationDao;
import com.scu.bpo.pojo.entity.Employee;
import com.scu.bpo.pojo.entity.MoneyNotification;
import com.scu.bpo.pojo.entity.Orderwithcontact;
import com.scu.bpo.service.impl.*;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
@MapperScan("com.scu.bpo.dao")
public class BpoApplicationTest {

    @Autowired
    OrderService orderService;

    @Autowired
    MoneyService moneyService;

    @Autowired
    BillService billService;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    CashFlowService cashFlowService;

    @Test
    void CreateNewNotification(){
//        MoneyNotification notification = new MoneyNotification();
//        Integer orderId = 9;
//        Float amount = null;
//        String moneyDescription = null;
//        Integer userRoleId = 1;
////        如果是发布方支付定金
//        if (userRoleId == 1){
//            amount = (float) 1000;
//            moneyDescription = "尝试" + "发布方定金";
//        }
//        notification.setOrderId(orderId);
//        notification.setMoneyTime(new Date());
//        notification.setAmount(amount);
//        notification.setMoneyType("支付定金");
//        notification.setUserId(1);
//        notification.setMoneyDescription(moneyDescription);
////        moneyNotificationDao.insert(notification);
//        billService.AddNewBill(notification);
//        userService.ChangeMoney(notification);
//        cashFlowService.AddNewCashFlow(notification);
    }

    @Test
    void TestMoneyController(){
//        Integer userRoleId = 1;
//        Integer userId = 1;
//        Orderwithcontact order = orderService.SelectByOrderId(9);
////        添加拨款单
//        MoneyNotification notification = moneyService.CreateDepositNotification(order, userId,userRoleId);
////        用户账单 添加支付定金记录
//        billService.AddNewBill(notification);
////        修改用户账户余额
//        userService.ChangeMoney(notification);
////        平台流水表 添加定金收款记录
//        cashFlowService.AddNewCashFlow(notification);
////        订单修改状态
//        orderService.DepositChangeOrderState(order,userRoleId);
    }
}
