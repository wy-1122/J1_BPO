package com.scu.bpo.controller.pages.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/pages/front")
public class DivideByRoleController {

    @RequestMapping("/Desk")
    public String DivideByRole(HttpSession session){
        Integer role = (Integer) session.getAttribute("userRoleId");
        if (role == 1) {
            return "pages/front/bpo_employer/EmployerProject";
        }
        return "redirect:/pages/front/EmployeeScheme";
    }
}
