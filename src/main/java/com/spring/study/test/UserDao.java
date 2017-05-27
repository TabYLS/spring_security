/*package com.spring.study.test;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

*//**
 * 使用template
 * @author YLS
 *
 *//*
@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate template;

	*//**
	 * 增加
	 * 
	 * @param user
	 * @return
	 *//*
	public int addUser(User user) {
		String sql = "insert into User(userName,sex) values(?,?)";

		return template.update(sql, user.getUserName(), user.getSex());
	}

	*//**
	 * 更新
	 * 
	 * @param user
	 * @return
	 *//*
	public int updateUser(User user) {
		String sql = " update User set userName = ? ,sex = ? where id = ? ";
		return template.update(sql, user.getUserName(), user.getSex(),
				user.getId());
	}

	*//**
	 * 查找返回一个值 采用queryForObject(String sql, Class<?> requiredType)
	 * 
	 * @return
	 *//*
	public long getUserCount() {
		String sql = " select count(1) from User ";
		return template.queryForObject(sql, long.class);
	}

	*//**
	 * 查找返回一个对象 采用queryForObject(String sql, RowMapper<User> rowMapper)
	 * 需要传入RowMapper对象
	 * 
	 * @param userId
	 * @return
	 *//*
	public User getUserById(int userId) {
		String sql = " select * from User where id = ? ";
		RowMapper<User> userMapper = new BeanPropertyRowMapper<>(User.class);
		return template.queryForObject(sql, userMapper, userId);
	}

	*//**
	 * 获取多个对象 采用query(String sql, RowMapper<User> rowMapper) 需要传入RowMapper对象
	 * RowMapper<User> userMapper = new BeanPropertyRowMapper<>(User.class);
	 * 
	 * @return
	 *//*
	public List<User> getUsers() {
		String sql = " select * from User ";
		RowMapper<User> userMapper = new BeanPropertyRowMapper<>(User.class);
		return template.query(sql, userMapper);
	}

	// ==========使用具名参数========================

	@Autowired
	private NamedParameterJdbcTemplate nameTemplate;

	public User getUserByNamedParameter(Map<String, Object> paramMap) {
		String sql = " select * from User where id = :userId ";

		return nameTemplate.queryForObject(sql, paramMap,
				new BeanPropertyRowMapper<>(User.class));
	}

}*/