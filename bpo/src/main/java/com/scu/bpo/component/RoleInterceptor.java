package com.scu.bpo.component;

import org.springframework.http.HttpRequest;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RoleInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        Object userRoleId = request.getSession().getAttribute("userRoleId");
        if((Integer) userRoleId == 1){
            return true;
        }else {
            request.setAttribute("errMessage","请切换用户角色登录");
            request.getRequestDispatcher("listPage").forward(request,response);
        }
        return false;
    }
}
