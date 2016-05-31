package com.fantasy.modules.functionManage.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fantasy.modules.functionManage.dao.ISysFunctionDao;
import com.fantasy.modules.functionManage.model.SysFunction;

@Repository(value="sysFunctionDao")
public class SysFunctionDao implements ISysFunctionDao{
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void add(SysFunction sysFunction) {
		// TODO Auto-generated method stub
		
	}

	public void delete(SysFunction sysFunction) {
		// TODO Auto-generated method stub
		
	}

	public void update(SysFunction sysFunction) {
		// TODO Auto-generated method stub
		
	}

	public SysFunction sysFunctionQuery(SysFunction sysFunction) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<SysFunction> sysFunctionQueryAll() {
		Session session = sessionFactory.getCurrentSession();
		//String companyCode=LoginAction.getCurrentUser().getCompanyCode();
		String companyCode="fantasy";
		List<SysFunction> list = session.createQuery(
				"from SYS_FUNCTION sf where sf.companyCode='"+companyCode+"' order by sf.sysFunId").list();
		//session.close();
		return list;
	}

	public List<SysFunction> sysFunctionQuery(List<String> list) {
		// TODO Auto-generated method stub
		return null;
	}

	public int maxId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
