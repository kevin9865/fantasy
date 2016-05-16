package com.fantasy.modules.userManage.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fantasy.modules.userManage.dao.IUserDao;
import com.fantasy.modules.userManage.model.User;

@Repository(value="userDao")
public class UserDao implements IUserDao{

	public void add(User user) {
		// TODO Auto-generated method stub
		
	}

	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	public User userQuery(User user) {
		User user2=new User();
		user2.setUsername(user.getUsername());
		user2.setPassword(user.getPassword());
		return user2;
	}

	public List<User> userQueryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> userFuzzyQuery(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public String maxUserId() {
		// TODO Auto-generated method stub
		return null;
	}

}
