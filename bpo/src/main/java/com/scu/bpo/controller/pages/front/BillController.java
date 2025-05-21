package com.scu.bpo.controller.pages.front;

import com.scu.bpo.pojo.entity.Bill;
import com.scu.bpo.pojo.entity.User;
import com.scu.bpo.service.impl.BillService;
import com.scu.bpo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/pages/front")
public class BillController {

    @Autowired
    BillService billService;

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/Bills")
    public String SelectBillByUserId(HttpSession session, Model model){
        Integer userId = (Integer)session.getAttribute("userId");
        Integer userRoleId = (Integer)session.getAttribute("userRoleId");
        User user = userService.SelectByUserId(userId);
        session.setAttribute("user",user);
        List<Bill> bills = billService.SelectByUserId(userId);
        model.addAttribute("bills",bills);
        if (userRoleId == 2) return "pages/front/bpo_employee/EmployeeBill";
        else return "pages/front/bpo_employer/EmployerBill";
    }

}
