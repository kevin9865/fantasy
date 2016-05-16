package com.fantasy.modules.userManage.service;

import java.util.List;

import com.fantasy.modules.userManage.model.User;

public interface IUserService {
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
	 * 更新用户权限
	 * 
	 * @param user
	 */
	public void updateUserAuth(User user);
	
	/**
	 * 更新密码
	 * @param user
	 */
	public void updatePwd(User user);

	/**
	 * 用户登陆查询
	 * 
	 * @param user
	 * @return
	 */
	public User loginQuery(User user);

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
	 * 查询用户
	 * 
	 * @param user
	 * @return
	 */
	public User userQuery(User user);
	
	/**
	 * 获取用户最大userId
	 * 
	 * @return
	 */
	public String maxUserId();
}
