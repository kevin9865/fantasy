package com.fantasy.modules.frameManage.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.mapping.Table;
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
import com.fantasy.util.widget.Widget;

@Controller
@Scope("prototype")
@RequestMapping("/mainAction")
public class MainAction {
	
	@Autowired
	@Qualifier("sysFunctionService")
	private ISysFunctionService iSysFunctionService;
	
	@RequestMapping(value = "/initMenu")
	@ResponseBody
	public Map<String, Object> initMenu(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		System.out.println("初始化菜单");
		
		//User user=(User) LoginAction.getCurrentUser(session);
		//System.out.println("获取用户:"+user.getUsername());
		
		Map<String, Object> map = new HashMap<String, Object>();

//		String menu=
//		"<li class='active'><a href='#'>Home</a></li>" +
//		"<li class='dropdown'>" +
//			"<a class='dropdown-toggle' data-toggle='dropdown' href='#'> 系统功能<span class='caret'></span></a>" +
//			"<ul class='bs-menu dropdown-menu'>" +
//				"<li class='dropdown-submenu'><a href='#'> 用户管理 </a>" +
//					"<ul class='bs-submenu dropdown-menu'>" +
//						"<li><a href='#'>用户查询</a></li>" +
//						"<li><a href='#'>用户添加</a></li>" +
//					"</ul>" +
//				"</li>" +
//				"<li><a href='#'>角色管理</a></li>" +
//				"<li><a href='#'>功能管理</a></li>" +
//			"</ul>" +
//		"</li>";
//		
//		map.put("menu", menu);
		
		
		
		List<SysFunction> list=iSysFunctionService.sysFunctionQueryAll();
		System.err.println("功能数量："+list.size());
		
		Widget wLi1=new Widget("li","class=\"active\"","");
		Widget wLi1_A1=new Widget("a","href=\"#\"","HOME");
		
		Widget wLi2=new Widget("li","class=\"dropdown\"","");
		Widget wLi2_A1=new Widget("a","class=\"dropdown-toggle\" href=\"#\"","系统功能");
		Widget wLi2_A1_Span1=new Widget("span","class=\"caret\"","");
		
		Widget wLi2_Ul1=new Widget("ul","class=\"bs-menu dropdown-menu\"","");
		Widget wLi2_Ul1_Li1=new Widget("li","class=\"dropdown-submenu\"","");
		Widget wLi2_Ul1_Li1_A1=new Widget("a","href=\"#\"","用户管理");
		Widget wLi2_Ul1_Li1_Ul1=new Widget("ul","class=\"bs-submenu dropdown-menu\"","");
		Widget wLi2_Ul1_Li1_Ul1_Li1=new Widget("li","","");
		Widget wLi2_Ul1_Li1_Ul1_Li1_A1=new Widget("a","href=\"#\"","用户查询");
		Widget wLi2_Ul1_Li1_Ul1_Li2=new Widget("li","","");
		Widget wLi2_Ul1_Li1_Ul1_Li2_A1=new Widget("a","href=\"#\"","用户添加");
		Widget wLi2_Ul1_Li2=new Widget("li","","");
		Widget wLi2_Ul1_Li2_A1=new Widget("a","href=\"#\"","角色管理");
		Widget wLi2_Ul1_Li3=new Widget("li","","");
		Widget wLi2_Ul1_Li3_A1=new Widget("a","href=\"#\"","功能管理");

		String liComp1=wLi1.addParamete(wLi1_A1).getComponent();
		String liComp2=wLi2.addParamete(wLi2_A1.addParamete(wLi2_A1_Span1))
						   .addParamete(wLi2_Ul1.addParamete(wLi2_Ul1_Li1.addParamete(wLi2_Ul1_Li1_A1)
														                 .addParamete(wLi2_Ul1_Li1_Ul1.addParamete(wLi2_Ul1_Li1_Ul1_Li1.addParamete(wLi2_Ul1_Li1_Ul1_Li1_A1))
														  							                  .addParamete(wLi2_Ul1_Li1_Ul1_Li2.addParamete(wLi2_Ul1_Li1_Ul1_Li2_A1))))
								                .addParamete(wLi2_Ul1_Li2.addParamete(wLi2_Ul1_Li2_A1))
								                .addParamete(wLi2_Ul1_Li3.addParamete(wLi2_Ul1_Li3_A1))).getComponent();
		
		//System.out.println(liComp1+liComp2);
		
		map.put("menu", liComp1+liComp2);
		
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
	
	public static void main(String[] args) {
		
//		Widget.getWidget(0,"div","class=\"collapse navbar-collapse\"","",list);
//		Widget.getWidget(1,"ul","class=\"nav navbar-nav\"","",list);
//		Widget.getWidget(2,"li","class=\"active\"","",list);
//		Widget.getWidget(3,"a","href=\"#\"","HOME",list);
		
		
		Widget wLi1=new Widget("li","class=\"active\"","");
		Widget wLi1_A1=new Widget("a","href=\"#\"","HOME");
		
		Widget wLi2=new Widget("li","class=\"dropdown\"","");
		Widget wLi2_A1=new Widget("a","class=\"dropdown-toggle\" href=\"#\"","系统功能");
		Widget wLi2_A1_Span1=new Widget("span","class=\"caret\"","");
		
		Widget wLi2_Ul1=new Widget("ul","class=\"bs-menu dropdown-menu\"","");
		Widget wLi2_Ul1_Li1=new Widget("li","class=\"dropdown-submenu\"","");
		Widget wLi2_Ul1_Li1_A1=new Widget("a","href=\"#\"","用户管理");
		Widget wLi2_Ul1_Li1_Ul1=new Widget("ul","class=\"bs-submenu dropdown-menu\"","");
		Widget wLi2_Ul1_Li1_Ul1_Li1=new Widget("li","","");
		Widget wLi2_Ul1_Li1_Ul1_Li1_A1=new Widget("a","href=\"#\"","用户查询");
		Widget wLi2_Ul1_Li1_Ul1_Li2=new Widget("li","","");
		Widget wLi2_Ul1_Li1_Ul1_Li2_A1=new Widget("a","href=\"#\"","用户添加");
		Widget wLi2_Ul1_Li2=new Widget("li","","");
		Widget wLi2_Ul1_Li2_A1=new Widget("a","href=\"#\"","角色管理");
		Widget wLi2_Ul1_Li3=new Widget("li","","");
		Widget wLi2_Ul1_Li3_A1=new Widget("a","href=\"#\"","功能管理");

		String liComp1=wLi1.addParamete(wLi1_A1).getComponent();
		String liComp2=wLi2.addParamete(wLi2_A1.addParamete(wLi2_A1_Span1))
			.addParamete(wLi2_Ul1.addParamete(wLi2_Ul1_Li1.addParamete(wLi2_Ul1_Li1_A1)
														  .addParamete(wLi2_Ul1_Li1_Ul1.addParamete(wLi2_Ul1_Li1_Ul1_Li1.addParamete(wLi2_Ul1_Li1_Ul1_Li1_A1))
														  							   .addParamete(wLi2_Ul1_Li1_Ul1_Li2.addParamete(wLi2_Ul1_Li1_Ul1_Li2_A1))))
								 .addParamete(wLi2_Ul1_Li2.addParamete(wLi2_Ul1_Li2_A1))
								 .addParamete(wLi2_Ul1_Li3.addParamete(wLi2_Ul1_Li3_A1))).getComponent();
		
		System.out.println(liComp1+liComp2);
		
		
	}
}
