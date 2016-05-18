package com.fantasy.modules.frameManage.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fantasy.modules.userManage.model.User;

public class AuthInterceptor extends HandlerInterceptorAdapter {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    	//1、resources资源 放行  
        if(request.getServletPath().startsWith("/resources")) {  
            return true;  
        }  
    	//2、用户检查页面 放行  
        if(request.getServletPath().startsWith("/login")) {  
            return true;  
        }  
              
        //3、TODO 比如退出、首页等页面无需登录，即此处要放行 允许游客的请求  
              
        //4、如果用户已经登录 放行    
        if(request.getSession().getAttribute("UserContext") != null) {  
            //更好的实现方式的使用cookie  
            return true;  
        }  
              
        //5、非法请求 即这些请求需要登录后才能访问  
        //重定向到登录页面  
        String loginUrl="/login.jsp";
        response.sendRedirect(request.getContextPath() + loginUrl);  
        return false;
    	
     }
}
