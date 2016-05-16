package com.fantasy.modules.frameManage.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("prototype")
@RequestMapping("/main")
public class MainAction {
	
	@RequestMapping(value = "/initMenu")
	public ModelAndView initMenu(HttpServletRequest request,HttpServletResponse response){
		System.out.println("登录用户:"+request.getParameter("username"));
		System.out.println("初始化菜单");
		
		ModelAndView mov=new ModelAndView();
		mov.setViewName("modules/main");
		return mov;
	}
}
