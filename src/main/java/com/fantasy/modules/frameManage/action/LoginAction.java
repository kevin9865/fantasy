package com.fantasy.modules.frameManage.action;

import java.util.HashMap;
import java.util.List;
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

import com.fantasy.modules.functionManage.model.SysFunction;
import com.fantasy.modules.functionManage.service.ISysFunctionService;
import com.fantasy.modules.userManage.model.User;
import com.fantasy.modules.userManage.service.IUserService;
import com.fantasy.util.widget.Widget;
import com.fantasy.util.widget.WidgetGroup;


@Controller
@Scope("prototype")
//@RequestMapping("/loginAction")
public class LoginAction {

	@Autowired
	@Qualifier("userService")
	private IUserService iUserService;
	
	@Autowired
	@Qualifier("sysFunctionService")
	private ISysFunctionService iSysFunctionService;

	/**
	 * 检查用户名密码是否有效
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
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
	    	System.out.println("登录用户:"+username);
	    	map.put("data", user);
	        map.put("flag", "1");
	    }
	    
		return map;
	}
	
	/**
	 * 跳转登陆页面
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/main")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		ModelAndView mov=new ModelAndView();
		User user=(User) session.getAttribute("UserContext");
		
		if(null==user){
			mov.setViewName("login");
		}else{
			mov.setViewName("modules/main");
			mov.addObject("username", user.getUsername());

			Widget w=initMenu();
			mov.addObject("menu", w.getHtml());
		}
		
		return mov;
	}
	
	/**
	 * 初始化菜单栏
	 * @return
	 */
	public Widget initMenu(){
		Widget wUl2=null;
		Widget wUl3=null;
		Widget wLi1=null;
		Widget wLi2=null;
		Widget wLi3=null;
		List<SysFunction> list=iSysFunctionService.sysFunctionQueryAll();
		for(SysFunction sf:list){
			if(sf.getLevelGrade()==1){
				wUl2=null;
				wUl3=null;
				
				wLi1=new Widget("li","class=\"dropdown\"","");
				Widget wA=new Widget("a","href=\"#\"",sf.getSysFunName());
				Widget wSpan=new Widget("span","class=\"caret\"","");
				wLi1.setComponent(wA.setComponent(wSpan));
			}else if (sf.getLevelGrade()==2) {
				wUl3=null;
				
				if(wUl2==null){
					wUl2=new Widget("ul","class=\"bs-menu dropdown-menu\"","");
					wLi1.setComponent(wUl2);
				}
				
				wLi2=new Widget("li","class=\"dropdown-submenu\"","");
				Widget wA=new Widget("a","href=\"#\"",sf.getSysFunName());
				wUl2.setComponent(wLi2.setComponent(wA));
			}
			else if (sf.getLevelGrade()==3) {
				if(wUl3==null){
					wUl3=new Widget("ul","class=\"bs-submenu dropdown-menu\"","");
					wLi2.setComponent(wUl3);
				}
				wLi3=new Widget("li","","");
				Widget wA=new Widget("a","href=\"#\"",sf.getSysFunName());
				
				wUl3.setComponent(wLi3.setComponent(wA));
				
			}
		}

		Widget w=WidgetGroup.group(wLi1);
		return w;
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
