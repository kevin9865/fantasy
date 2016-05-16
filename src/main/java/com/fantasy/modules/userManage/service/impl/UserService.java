package com.fantasy.modules.userManage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fantasy.modules.userManage.dao.IUserDao;
import com.fantasy.modules.userManage.model.User;
import com.fantasy.modules.userManage.service.IUserService;

@Service(value="userService")
public class UserService implements IUserService{
	
	@Autowired
	@Qualifier("userDao")
	private IUserDao iUserDao;

	public void add(User user) {
		// TODO Auto-generated method stub
		
	}

	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	public void updateUserAuth(User user) {
		// TODO Auto-generated method stub
		
	}

	public void updatePwd(User user) {
		// TODO Auto-generated method stub
		
	}

	public User loginQuery(User user) {
		User u=iUserDao.userQuery(user);
		return u;
	}

	public List<User> userQueryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> userFuzzyQuery(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public User userQuery(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public String maxUserId() {
		// TODO Auto-generated method stub
		return null;
	}

}
