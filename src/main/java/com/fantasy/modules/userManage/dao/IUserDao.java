package com.fantasy.modules.userManage.dao;

import java.util.List;

import com.fantasy.modules.userManage.model.User;

public interface IUserDao {
	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	public void add(User user);

	/**
	 * 删除用户
	 * 
	 * @param user
	 */
	public void delete(User user);

	/**
	 * 更新用户
	 * 
	 * @param user
	 */
	public void update(User user);

	/**
	 * 查询用户
	 * 
	 * @param user
	 * @return
	 */
	public User userQuery(User user);

	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	public List<User> userQueryAll();

	/**
	 * 模糊查询用户
	 * 
	 * @param user
	 * @return
	 */
	public List<User> userFuzzyQuery(User user);

	/**
	 * 获取用户最大userId
	 * 
	 * @return
	 */
	public String maxUserId();
}
