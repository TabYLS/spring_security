/*package com.spring.study.security3_test;

import java.util.List;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class TestDao {
	@Autowired 
	private JdbcTemplate template;
	
	public TestDao(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
		
	}
	
	public List<String> getAllAuthorityName() {
		return allAuthorityName;
	}

	*//**
	 * 获取一个用户所拥有的权限
	 * @param username
	 * @return
	 *//*
	public List<String> getAuthorityName(String username) {
		String sql = "select u.username,r.name as authority "
				+ "from my_user u "
				+ "join my_user_role ur on u.id=ur.user_id "
				+ "join my_role r on r.id=ur.role_id "
				+ "where u.username=?";
		RowMapper<String> userMapper = new BeanPropertyRowMapper<>(String.class);
		return template.query(sql, userMapper,username);
	}

	*//**
	 * 根据权限获取资源
	 * @param auth
	 * @return
	 *//*
	public List<String> getResource(String auth) {
		String sql = "SELECT re.res_string, r.name "
				+ "FROM my_role r "
				+ "JOIN my_resc_role rr ON r.id = rr.role_id "
				+ "JOIN my_resc re ON re.id = rr.resc_id WHERE r.name=?";
		RowMapper<String> userMapper = new BeanPropertyRowMapper<>(String.class);
		return template.query(sql, userMapper,auth);
	}

	*//**
	 * 获取所有权限
	 * @return
	 *//*
	public List<String> getAllAuthorityName() {
		String sql = "SELECT name FROM my_role";
		RowMapper<String> userMapper = new BeanPropertyRowMapper<>(String.class);
		return template.query(sql, userMapper);
	}

	*//**
	 * 获取用户密码
	 * @param username
	 * @return
	 *//*
	public String getPWD(String username) {
		String sql = "SELECT password FROM my_user WHERE username = ?";
		RowMapper<String> userMapper = new BeanPropertyRowMapper<>(String.class);
		return template.queryForObject(sql, userMapper, username);
	}

	public String getPWD(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
*/