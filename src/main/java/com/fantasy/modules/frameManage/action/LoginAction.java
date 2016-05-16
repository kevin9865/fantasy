package com.fantasy.modules.frameManage.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fantasy.modules.userManage.model.User;
import com.fantasy.modules.userManage.service.IUserService;
import com.fantasy.util.Tools;


@Controller
@Scope("prototype")
@RequestMapping("/loginAction")
public class LoginAction {
	
	@Autowired
	@Qualifier("userService")
	private IUserService iUserService;

	@RequestMapping(value = "/login")
	@ResponseBody
	public Map<String, Object> query(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
        String username = request.getParameter("username");
        String password = request.getParameter("password");
		
	    User loginUser = new User();  
	    loginUser.setUsername(username);
	    loginUser.setPassword(password);
	    
	    User user=iUserService.loginQuery(loginUser);
	    
	    if(user==null){
	    	Map<String, Object> error=new HashMap<String,Object>();
		    error.put("error", "用户名或密码错误");
		    
		    map.put("data", error);
	        map.put("flag", "0");
	    	
	    }else{
	    	map.put("data", user);
	        map.put("flag", "1");
	    }
	    
		return map;
	}
	
	
	@RequestMapping(value = "/loginCheck")
	public ModelAndView loginCheck(HttpServletRequest request,HttpServletResponse response) {
		System.out.println(request.getParameterMap());
        String str = request.getParameter("username");
        System.out.println(str);
        
        ModelAndView mov=new ModelAndView();  
        if(str.equals("1")){
        	mov.setViewName("login");
        }else{
        	mov.setViewName("modules/main");
        }
        
		return mov;
	}
	
	public static void main(String[] args) {
//		ApplicationContext factory = new ClassPathXmlApplicationContext("action.xml");
//		LoginAction loginAction=(LoginAction) factory.getBean("loginAction");
//		
//		IUserService userService=loginAction.getUserService();
//		User loginUser = new User();  
//		loginUser.setUsername("123");
//		loginUser.setPassword("234");
//		User user=userService.loginQuery(loginUser);
//		System.out.println(user.getUsername());
	}
}
