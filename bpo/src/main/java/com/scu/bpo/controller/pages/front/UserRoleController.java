package com.scu.bpo.controller.pages.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/pages/front")
public class UserRoleController {

    @RequestMapping("/UserRoleChanged")
    public String ChangeRole(Integer role, HttpSession session){
        session.setAttribute("userRoleId",role);
        return "redirect:/pages/front/Desk";
    }
}