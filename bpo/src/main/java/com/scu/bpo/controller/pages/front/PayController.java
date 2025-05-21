package com.scu.bpo.controller.pages.front;

import com.scu.bpo.pojo.entity.Orderwithcontact;
import com.scu.bpo.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/pages/front")
public class PayController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/Pay")
    public String EmployerPay(Integer orderId, Model model,String PayType){
        Orderwithcontact order = orderService.SelectByOrderId(orderId);
        model.addAttribute("order",order);
        model.addAttribute("PayType",PayType);
        return "pages/front/pay";
    }
}
