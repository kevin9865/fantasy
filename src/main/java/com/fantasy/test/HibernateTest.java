package com.fantasy.test;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fantasy.modules.functionManage.service.impl.SysFunctionService;

public class HibernateTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory session=(SessionFactory) factory.getBean("sessionFactory");
		session.openSession();
	}
}
