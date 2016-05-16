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

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fantasy.modules.userManage.model.User;
import com.fantasy.util.Tools;


@Controller
@Scope("prototype")
@RequestMapping("/login")
public class LoginAction {
	
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
	
	@RequestMapping(value = "/query")
	@ResponseBody
	public Map<String, Object> query(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
        String str = request.getParameter("username");
		
		List<User> list = new ArrayList<User>();  
	    User um = new User();  
	    um.setUsername("测试1");
	    um.setPassword("密码1");
	    list.add(um); 
	    
	    if(str.equals("123")){
	    	map.put("data", list);
	        map.put("flag", "1");
	        
	    }else{
	    	Map<String, Object> error=new HashMap<String,Object>();
		    error.put("error", "用户名或密码错误");
		    
		    map.put("data", error);
	        map.put("flag", "0");
	    }
	    
		return map;
	}
}
