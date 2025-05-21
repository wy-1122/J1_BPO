package com.scu.bpo.controller.pages.front;

import com.scu.bpo.pojo.entity.BiddingScheme;
import com.scu.bpo.pojo.entity.Orderwithcontact;
import com.scu.bpo.pojo.entity.Project;
import com.scu.bpo.service.BiddingSchemeService;
import com.scu.bpo.service.ProjectService;
import com.scu.bpo.service.impl.BiddingSchemeServiceImpl;
import com.scu.bpo.service.impl.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/pages/front")
public class OrderController {

    public static Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    OrderService orderService;

    @Resource
    ProjectService projectService;

    @Autowired
    BiddingSchemeServiceImpl biddingSchemeService;

    //发布方确认该竞标方案，生成订单。
    @RequestMapping("/CreateOrder")
    public String CreateOrder(Integer projectId, Integer userEmployeeId,Float orderAmount,Integer schedule, HttpSession session){
        //获取确认竞标方案的发布方ID
        Integer userEmployerId = (Integer)session.getAttribute("userEmployerId");
        //生成新的订单
        orderService.Insert(projectId,userEmployeeId,userEmployerId,orderAmount,schedule);
        //修改项目状态为已出单
        projectService.UpdateProjectType(projectId,"已出单");
        //修改竞标方案为已选中状态
        biddingSchemeService.updateStatus(projectId,userEmployeeId,userEmployerId,"已选中");
        return "redirect:/EmployerProject";
    }

//    发布方订单查看
    @RequestMapping("/EmployerQueryOrder")
    public String QueryOrderByEmployerId(HttpSession session,Model model){
        Integer userEmployerId = (Integer) session.getAttribute("userEmployerId");
        List<Orderwithcontact> results = orderService.QueryOrderByEmployerId(userEmployerId);
        model.addAttribute("EmployerOrders",results);
        return "pages/front/bpo_employer/EmployerOrder";
    }

//    承包方订单查看
    @RequestMapping("/EmployeeQueryOrder")
    public String QueryOrderByEmployeeId(HttpSession session,Model model){
        Integer userEmployeeId = (Integer) session.getAttribute("userEmployeeId");
        List<Orderwithcontact> results = orderService.QueryOrderByEmployeeId(userEmployeeId);
        model.addAttribute("EmployeeOrders",results);
        return "pages/front/bpo_employee/EmployeeOrder";
    }

//    发布方确认完成订单
    @RequestMapping("/EmployerFinishOrder")
    public String EmployerFinishOrder(HttpSession session,Integer orderId){
        Integer userEmployeeId = (Integer) session.getAttribute("userRoleId");
        orderService.FinishOrder(orderId,userEmployeeId);
//        跳转回发布方订单查看
        return "redirect:/pages/front/EmployerQueryOrder";
    }

//    承包方确认完成订单
    @RequestMapping("/EmployeeFinishOrder")
    public String EmployeeFinishOrder(HttpSession session,Integer orderId){
        Integer userEmployeeId = (Integer) session.getAttribute("userRoleId");
        orderService.FinishOrder(orderId,userEmployeeId);
    //        跳转回承包方方订单查看
        return "redirect:/pages/front/EmployeeQueryOrder";
    }
}
