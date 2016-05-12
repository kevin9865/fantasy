package com.fantasy.modules.frameManage.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@Scope("prototype")
@RequestMapping("/login")
public class LoginAction {
	
	@RequestMapping(value = "/check")
	public ModelAndView check() {
		System.out.println("��ѯ");

		ModelAndView mov=new ModelAndView();  
        mov.setViewName("login");
        //mov.addObject("msg", "(�û�"+name+" delete success)");
        
		return mov;
	}
	
	@RequestMapping(value = "/query")
	public ModelAndView query(HttpServletRequest request,HttpServletResponse response) {
		//����  
//        String str = request.getParameter("orderJson");
//        System.out.println(str);
//        JSONObject jb=new JSONObject();   
//        //��json��ʽ���ַ���ת��Ϊjson���󣬲�ȡ�øö���ġ�userName������ֵ  
//        String o=(String)jb.fromObject(str).get("username");  
//        System.out.println(o);
        
        

		ModelAndView mov=new ModelAndView();  
        mov.setViewName("modules/main");
        //mov.addObject("msg", "(�û�"+name+" delete success)");
        
		return mov;
	}
}
