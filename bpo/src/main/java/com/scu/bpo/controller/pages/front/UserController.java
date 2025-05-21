package com.scu.bpo.controller.pages.front;

import com.scu.bpo.pojo.entity.User;
import com.scu.bpo.pojo.entity.UserEmployee;
import com.scu.bpo.pojo.entity.UserEmployer;
import com.scu.bpo.pojo.entity.UserRole;
import com.scu.bpo.service.UserEmployeeService;
import com.scu.bpo.service.UserEmployerService;
import com.scu.bpo.service.UserRoleService;
import com.scu.bpo.service.UserService;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/pages/front")
public class UserController {
    @Resource
    UserService userService;
    @Resource
    UserRoleService userRoleService;
    @Resource
    UserEmployerService userEmployerService;
    @Resource
    UserEmployeeService userEmployeeService;

    @RequestMapping("login")
    public String Login(HttpServletRequest request, User user, Model model)
    {
        boolean loginResult = userService.login(user);
        if(loginResult){
            model.addAttribute("successMsg","登陆成功");
            HttpSession session = request.getSession();
            session.setAttribute("userName",user.getUserName());
            session.setAttribute("userRoleId",1);

            User user2 = userService.findUser(user.getUserName());
            session.setAttribute("user",user2);

            Integer userId = user2.getUserId();
            session.setAttribute("userId",userId);

            UserRole userRole = userRoleService.findUserRoleEmployer(userId);
            Integer userEmployerId = userRole.getUserRoleId();
            session.setAttribute("userEmployerId",userEmployerId);

            userRole = userRoleService.findUserRoleEmployee(userId);
            Integer userEmployeeId = userRole.getUserRoleId();
            session.setAttribute("userEmployeeId",userEmployeeId);

            return "redirect:/listPage";
        }
        else{
            model.addAttribute("errMessage","账号或密码错误，请重新输入");
            return "pages/front/login";
        }
    }

    @RequestMapping("register")
    public String Register(HttpSession session,User user, String rePassword, Model model){
        String regResult = userService.register(user,rePassword);
        if ("注册成功".equals(regResult)){
            //为用户添加身份
            int userId = userService.findUser(user.getUserName()).getUserId();
            boolean flag = userRoleService.addNewUserRole(userId);
            //需要查询出两个身份对应的user_Role_ID
            Integer userEmployerId,userEmployeeId;
            userEmployerId = userRoleService.findUserRoleEmployer(userId).getUserRoleId();
            session.setAttribute("userEmployerId",userEmployerId);
            userEmployeeId = userRoleService.findUserRoleEmployee(userId).getUserRoleId();
            session.setAttribute("userEmployeeId",userEmployeeId);
            //添加发包方表中信息
            UserEmployer userEmployer = new UserEmployer();
            userEmployer.setUserEmployerId(userEmployerId);
            userEmployer.setUserEmployerName(user.getUserName());
            int addEmployer = userEmployerService.addNewEmployer(userEmployer);
//            System.out.println(addEmployer);
            //添加接包方表中信息

            UserEmployee userEmployee = new UserEmployee();
            userEmployee.setUserEmployeeId(userEmployeeId);
            int addEmployee = userEmployeeService.addNewEmployee(userEmployee);
//            System.out.println(addEmployee);
            //传递信息
            model.addAttribute("successMsg",regResult);
            session.setAttribute("User",user.getUserName());
            session.setAttribute("userRoleId",1);
            return "redirect:/listPage";
        }
        else {
            model.addAttribute("errMessage",regResult);
            return "pages/front/register";
        }
    }

    @RequestMapping("/RedirectToSelfIntroduction")
    public String RedirectToSelfIntroduction(HttpSession session){
        Integer userRoleId = (Integer) session.getAttribute("userRoleId");
        if(userRoleId == 1){
            return "pages/front/personal_info/employer_basis_info";
        }
        else if(userRoleId == 2){
            return "redirect:/listPage";
        }
        return "redirect:/listPage";
    }

}
