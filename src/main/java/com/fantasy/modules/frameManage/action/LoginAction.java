package com.fantasy.modules.frameManage.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fantasy.modules.userManage.model.User;
import com.fantasy.modules.userManage.service.IUserService;


@Controller
@Scope("prototype")
//@RequestMapping("/loginAction")
public class LoginAction {

	@Autowired
	@Qualifier("userService")
	private IUserService iUserService;

	@RequestMapping(value = "/login")
	@ResponseBody
	public Map<String, Object> checkUser(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
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
	    	session.setAttribute("UserContext", user);
	    	map.put("data", user);
	        map.put("flag", "1");
	    }
	    
		return map;
	}
	
	@RequestMapping(value = "/main")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String username=request.getParameter("username");
		System.out.println("登录用户:"+username);
		
		ModelAndView mov=new ModelAndView();
		User user=(User) session.getAttribute("UserContext");
		
		if(null==user){
			mov.setViewName("login");
		}else{
			mov.setViewName("modules/main");
			mov.addObject("username", user.getUsername());
		}
		
		return mov;
	}
	
	/**
	 * 获取当前用户
	 * 
	 * @return
	 */
	public static User getCurrentUser(HttpSession session) {
		User user = (User) session.getAttribute("UserContext");
		if(null==user){
			return null;
		}else{
			return user;
		}
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
