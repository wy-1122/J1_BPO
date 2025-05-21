package com.scu.bpo.controller.pages.front;

import com.scu.bpo.pojo.entity.MoneyNotification;
import com.scu.bpo.pojo.entity.Orderwithcontact;
import com.scu.bpo.pojo.entity.UserRole;
import com.scu.bpo.service.ProjectService;
import com.scu.bpo.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Money")
@Transactional
public class MoneyController {

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

    @Autowired
    ProjectService projectService;

    @Autowired
    UserRoleServiceImpl userRoleService;

    @RequestMapping("/UserPayDeposit")
    public String UserPayForOrder(Integer orderId, HttpSession session){
        Integer userRoleId = (Integer)session.getAttribute("userRoleId");
        Integer userId = (Integer)session.getAttribute("userId");
        Orderwithcontact order = orderService.SelectByOrderId(orderId);
//        添加定金拨款单
        MoneyNotification notification = moneyService.CreateDepositNotification(order, userId,userRoleId);
//        用户账单 添加支付定金记录
        billService.AddNewBill(notification);
//        修改用户账户余额
        userService.ChangeMoney(notification);
//        平台流水表 添加定金收款记录
        cashFlowService.AddNewCashFlow(notification);
//        订单修改状态
        orderService.DepositChangeOrderState(order,userRoleId);
        if (userRoleId == 1) return "redirect:/pages/front/EmployerQueryOrder";
        return "redirect:/pages/front/EmployeeQueryOrder";
    }

    @RequestMapping("/EmployerPayAccountDue")
    public String EmployerPayAccountDue(Integer orderId, HttpSession session){
        Integer userRoleId = (Integer)session.getAttribute("userRoleId");
        if (userRoleId != 1){
            System.out.println("====ERROR In EmployerPayAccountDue====");
            return "";
        }
        Integer userId = (Integer)session.getAttribute("userId");
        Orderwithcontact order = orderService.SelectByOrderId(orderId);
//        计算尾款
        float AccountDue = order.getOrderAmount() - order.getEmployerDeposit();
//        添加尾款拨款单
        MoneyNotification notification = moneyService.CreateNewNotification(order, userId,"支付尾款",AccountDue);
//        用户账单 添加支付尾款记录
        billService.AddNewBill(notification);
//        修改用户账户余额
        userService.ChangeMoney(notification);
//        平台流水表 添加尾款收款记录
        cashFlowService.AddNewCashFlow(notification);

//        计算全额转付 = 订单总金额 + 承包方支付的定金
        float Sum = order.getOrderAmount() + order.getEmployeeDeposit();
//        根据订单中承包方的UserEmployeeId超找出UserID
        UserRole userRole = userRoleService.SelectByUserRoleId(order.getUserEmployeeId());
//        添加全额转付拨款单
        MoneyNotification notification1 = moneyService.CreateNewNotification(order, userRole.getUserId() , "全额转付",Sum);
//        用户账单 添加全额转付到账记录
        billService.AddNewBill(notification1);
//        修改用户账户余额
        userService.ChangeMoney(notification1);
//        平台流水表 添加全额转付记录
        cashFlowService.AddNewCashFlow(notification1);

//        修改订单状态为 订单完成
        orderService.AccountDueChangeOrderState(order.getOrderId());
//        修改项目状态为 已完成
        projectService.UpdateProjectType(order.getProjectId(),"已完成");
        return "redirect:/pages/front/EmployerQueryOrder";
    }
}
