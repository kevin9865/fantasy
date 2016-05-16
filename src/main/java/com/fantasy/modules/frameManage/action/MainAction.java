package com.fantasy.modules.frameManage.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public ModelAndView initMenu(HttpServletRequest request,HttpServletResponse response){
		String username=request.getParameter("username");
		System.out.println("登录用户:"+username);
		System.out.println("初始化菜单");
		
		ModelAndView mov=new ModelAndView();
		mov.setViewName("modules/main");
		mov.addObject("username", username);
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
