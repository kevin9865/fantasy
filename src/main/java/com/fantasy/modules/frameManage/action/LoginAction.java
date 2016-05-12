package com.fantasy.modules.frameManage.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fantasy.modules.userManage.model.User;


@Controller
//@Scope("prototype")
@RequestMapping("/login")
public class LoginAction {
	
	@RequestMapping(value = "/check")
	public ModelAndView check() {

		ModelAndView mov=new ModelAndView();  
        mov.setViewName("login");
        
		return mov;
	}
	
	@RequestMapping(value = "/query")
	public String query(HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("chaxun");
//		Map<String, String[]> paramMap = request.getParameterMap();
//		System.out.println(paramMap.get("orderJson"));
//		
//		
//        String str = request.getParameter("orderJson");
//        System.out.println(str);
//        JSONObject jb=new JSONObject();   
//        String o=(String)jb.fromObject(str).get("username");  
//        System.out.println(o);
		
        //System.out.println(user.getUsername());
		System.out.println("查询");
		ModelAndView mov=new ModelAndView();  
		mov.setViewName("32145");
        
        User user2=new User();
        user2.setUsername("tom");
        user2.setPassword("qwe");
        mov.addObject(user2);
        
        
        List<User> list = new ArrayList<User>();
        User um = new User();
        um.setUsername("sss");
        um.setPassword("123");
        list.add(um);
        Map<String, Object> modelMap = new HashMap<String, Object>(3);
        modelMap.put("total", "1");
        modelMap.put("data", list);
        modelMap.put("success", "true");
		return null;
	}
}
