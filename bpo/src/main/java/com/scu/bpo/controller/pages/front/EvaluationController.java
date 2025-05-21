package com.scu.bpo.controller.pages.front;

import com.scu.bpo.pojo.entity.Evaluationdetails;
import com.scu.bpo.pojo.entity.Orderwithcontact;
import com.scu.bpo.pojo.entity.UserRole;
import com.scu.bpo.service.UserRoleService;
import com.scu.bpo.service.impl.EvaluationService;
import com.scu.bpo.service.impl.OrderService;
import com.scu.bpo.service.impl.UserRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/pages/front")
public class EvaluationController {

    @Autowired
    OrderService orderService;

    @Autowired
    EvaluationService evaluationService;

    @RequestMapping("/EvaluationPage")
    public String EvaluationPage(Integer orderId, HttpSession session, Model model){
        Integer userRoleId = (Integer)session.getAttribute("userRoleId");
        Orderwithcontact order = orderService.SelectByOrderId(orderId);
        model.addAttribute("projectName",order.getProjectName());
        if (userRoleId == 1) model.addAttribute("userRoleId",order.getUserEmployeeId());
        else model.addAttribute("userRoleId",order.getUserEmployerId());
        model.addAttribute("orderId",order.getOrderId());
        return "pages/front/Evaluation";
    }

    @RequestMapping("/Evaluate")
    public String evaluate(Integer userRoleId,Integer orderId,String Evaluation,HttpSession session){
        evaluationService.AddEvaluation(userRoleId,orderId,Evaluation);
        Integer role = (Integer)session.getAttribute("userRoleId");
        orderService.EvaluationChangeOrderState(orderId,role);
        if (role == 1) return "redirect:/pages/front/EmployerQueryOrder";
        return "redirect:/pages/front/EmployeeQueryOrder";
    }

    @RequestMapping("/ShowEvaluation")
    public String ShowEvaluation(HttpSession session,Model model){
        Integer role = (Integer)session.getAttribute("userRoleId");
        if (role == 1)
        {
            Integer userEmployerId = (Integer)session.getAttribute("userEmployerId");
            List<Evaluationdetails> list = evaluationService.SelectByUserRoleId(userEmployerId);
            model.addAttribute("Evaluations",list);
            return "pages/front/bpo_employer/EmployerEvaluation";
        }
        else
        {
            Integer userEmployerId = (Integer)session.getAttribute("userEmployeeId");
            List<Evaluationdetails> list = evaluationService.SelectByUserRoleId(userEmployerId);
            model.addAttribute("Evaluations",list);
            return "pages/front/bpo_employee/EmployeeEvaluation";
        }
    }
}
