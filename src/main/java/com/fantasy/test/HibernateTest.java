package com.fantasy.test;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.fantasy.modules.functionManage.service.impl.SysFunctionService;

public class HibernateTest {
	public static void main(String[] args) {
		
	}
	
	
	
	public void test(){
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory session=(SessionFactory) factory.getBean("sessionFactory");
		session.getCurrentSession();
	}
	@Test
	@Transactional
	public void test1(){
		test();
		
	}
}
