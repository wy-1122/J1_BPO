package com.scu.bpo.service.impl;

import com.scu.bpo.dao.OrdersDao;
import com.scu.bpo.dao.OrderwithcontactDao;
import com.scu.bpo.pojo.entity.Orders;
import com.scu.bpo.pojo.entity.Orderwithcontact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    public static Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    OrdersDao ordersDao;

    @Autowired
    OrderwithcontactDao orderwithcontactDao;

    public boolean Insert(Integer projectId, Integer userEmployeeId,Integer userEmployerId,Float orderAmount,Integer schedule){
        Integer rows = ordersDao.insert(
                new Orders(projectId,userEmployeeId,userEmployerId,new Date(), "未付定金",orderAmount, schedule,orderAmount * (float)0.2,orderAmount * (float)0.1));
        logger.debug(rows.toString());
        if (rows == 1) return true;
        return false;
    }

    public List<Orderwithcontact> QueryOrderByEmployerId(Integer userEmployerId){
        List<Orderwithcontact> results = orderwithcontactDao.SelectByuserEmployerId(userEmployerId);
        return results;
    }

    public List<Orderwithcontact> QueryOrderByEmployeeId(Integer userEmployeeId){
        List<Orderwithcontact> results = orderwithcontactDao.SelectByuserEmployeeId(userEmployeeId);
        return results;
    }

    public Orderwithcontact SelectByOrderId(Integer orderId){
        Orderwithcontact result = orderwithcontactDao.SelectByOrderId(orderId);
        return result;
    }

//    支付定金改变订单状态
    public void DepositChangeOrderState(Orderwithcontact order,Integer userRoleId){
        Integer orderId = order.getOrderId();
        String orderState = order.getOrderState();
        String newState = null;
        if ("未付定金".equals(orderState)){
            if (userRoleId == 1) newState = "承包方未付定金";
            else newState = "发布方未付定金";
        } else if ("承包方未付定金".equals(orderState)){
            if (userRoleId == 2) newState = "进行中";
        } else if ("发布方未付定金".equals(orderState)){
            if (userRoleId == 1) newState = "进行中";
        }
        Orders orders = new Orders();
        orders.setOrderId(orderId);
        orders.setOrderState(newState);
        ordersDao.updateByPrimaryKeySelective(orders);
    }

//    （发布方、承包方）完成订单改变订单状态
    public void FinishOrder(Integer orderId,Integer role){
        Orders orders = ordersDao.selectByPrimaryKey(orderId);
        String orderState = orders.getOrderState();
        if (role == 1){ //发布方完成订单
            if ("进行中".equals(orderState)) orders.setOrderState("发布方确认完成订单");
            else if ("承包方确认完成订单".equals(orderState)) orders.setOrderState("未支付尾款");
        }
        else if (role == 2){    // 承包方完成订单
            if ("进行中".equals(orderState)) orders.setOrderState("承包方确认完成订单");
            else if ("发布方确认完成订单".equals(orderState)) orders.setOrderState("未支付尾款");
        }
        ordersDao.updateByPrimaryKeySelective(orders);
    }

//    支付尾款改变订单状态
    public void AccountDueChangeOrderState(Integer orderId){
        Orders orders = ordersDao.selectByPrimaryKey(orderId);
        orders.setOrderState("订单完成");
        ordersDao.updateByPrimaryKeySelective(orders);
    }

//    评价改变订单状态
    public void EvaluationChangeOrderState(Integer orderId,Integer role){
        Orders orders = ordersDao.selectByPrimaryKey(orderId);
        String state = orders.getOrderState();
        if (role == 1){
            if ("订单完成".equals(state)) orders.setOrderState("发布方已评价");
            else if ("承包方已评价".equals(state)) orders.setOrderState("评价完成");
        }else if (role == 2){
            if ("订单完成".equals(state)) orders.setOrderState("承包方已评价");
            else if ("发布方已评价".equals(state)) orders.setOrderState("评价完成");
        }
        ordersDao.updateByPrimaryKeySelective(orders);
    }
}