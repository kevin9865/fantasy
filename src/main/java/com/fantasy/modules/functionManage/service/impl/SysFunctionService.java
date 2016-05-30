package com.fantasy.modules.functionManage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fantasy.modules.functionManage.dao.ISysFunctionDao;
import com.fantasy.modules.functionManage.model.SysFunction;
import com.fantasy.modules.functionManage.service.ISysFunctionService;

@Service(value="sysFunctionService")
public class SysFunctionService implements ISysFunctionService{

	@Autowired
	@Qualifier("sysFunctionDao")
	private ISysFunctionDao iSysFunctionDao;
	
	public void add(SysFunction sysFunction) {
		// TODO Auto-generated method stub
		
	}

	public void delete(SysFunction sysFunction) {
		// TODO Auto-generated method stub
		
	}

	public void deleteBatch(List<SysFunction> list) {
		// TODO Auto-generated method stub
		
	}

	public void update(SysFunction sysFunction) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public List<SysFunction> sysFunctionQueryAll() {
		return iSysFunctionDao.sysFunctionQueryAll();
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
