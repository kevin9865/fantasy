package com.fantasy.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.bind.annotation.InitBinder;

import com.fantasy.modules.functionManage.service.impl.SysFunctionService;
import com.fasterxml.classmate.AnnotationConfiguration;

@Transactional
public class HibernateTest {
	public static void main(String[] args) {
		
	}
	
	static SysFunctionService service;
	@BeforeClass
	public static void init(){
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory session=(SessionFactory) factory.getBean("sessionFactory");

		session.getCurrentSession();
	}

	@Test
	public void test(){
		
		//service.sysFunctionQueryAll();
		
//		SessionFactory session=(SessionFactory) factory.getBean("sessionFactory");
//		
//		try {
//			session.getCurrentSession();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
