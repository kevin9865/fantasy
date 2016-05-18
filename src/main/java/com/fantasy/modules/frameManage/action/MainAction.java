package com.fantasy.modules.frameManage.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fantasy.modules.userManage.model.User;

@Controller
@Scope("prototype")
@RequestMapping("/mainAction")
public class MainAction {
	
	
	@RequestMapping(value = "/initMenu")
	@ResponseBody
	public Map<String, Object> initMenu(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		System.out.println("初始化菜单");
		
		//User user=(User) LoginAction.getCurrentUser(session);
		//System.out.println("获取用户:"+user.getUsername());
		
		Map<String, Object> map = new HashMap<String, Object>();

		String menu=
		"<li class='active'><a href='#'>Home</a></li>" +
		"<li class='dropdown'>" +
			"<a class='dropdown-toggle' data-toggle='dropdown' href='#'> 系统功能<span class='caret'></span></a>" +
			"<ul class='bs-menu dropdown-menu'>" +
				"<li class='dropdown-submenu'><a href='#'> 用户管理 </a>" +
					"<ul class='bs-submenu dropdown-menu'>" +
						"<li><a href='#'>用户查询</a></li>" +
						"<li><a href='#'>用户添加</a></li>" +
					"</ul>" +
				"</li>" +
				"<li><a href='#'>角色管理</a></li>" +
				"<li><a href='#'>功能管理</a></li>" +
			"</ul>" +
		"</li>";
		
		
		map.put("menu", menu);
		
		return map;
	}
	
	@RequestMapping(value = "/logout")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response,HttpSession session){

		session.setAttribute("UserContext", null);
		ModelAndView mov=new ModelAndView();
		mov.setViewName("redirect:/login.jsp");
		
		return mov;
	}
	
	@RequestMapping(value = "/test")
	@ResponseBody
	public Map<String, Object> test(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		User user = new User();  
		user.setUsername("test");
		user.setPassword("test123");
		
	    map.put("data", user);
	    
		return map;
	}
}
