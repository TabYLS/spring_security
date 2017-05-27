package com.spring.study.dao;

import com.spring.study.domain.User;

public interface IUserDao {
	
	/**
	 * 根据用户名返回用户信息
	 * @param username 用户名
	 * @return 用户信息
	 */
	public User load(String username);

}
