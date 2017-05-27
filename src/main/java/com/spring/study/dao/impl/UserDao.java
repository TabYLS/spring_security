package com.spring.study.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.study.dao.IUserDao;
import com.spring.study.domain.Role;
import com.spring.study.domain.User;

@Repository("userJdbcDao")
public class UserDao implements IUserDao {

	//@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private User user = null;
	private List<Role> roles = null;
	
	/**
	 * 注入数据源
	 * @param dataSource
	 */
	@Resource
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public User load(String username) {
		user = new User();
		roles = new ArrayList<Role>();
		String sql = "SELECT u.id userid, u.username, u.password, u.status, u.descn userdescn, "
				+ " r.id rid, r.name rname, r.descn rdescn "
				+ " FROM my_user u LEFT "
				+ " JOIN my_user_role ur "
				+ " ON ur.user_id = u.id "
				+ " LEFT JOIN my_role AS r "
				+ " ON ur.role_id = r.id"
				+ "WHERE u.username = ?";
		/**
		 * 第一个参数是SQL语句 第二个参数是SQL语句中的参数值，需要传入一个对象数组（可以传入多个参数）
		 * 第三参数是一个RowMapper，这个rowMapper可以完成一个对象和数据库字段的对应，实现这个RowMapper需要
		 * 实现mapRow方法，在mapRow方法中有rs这个参数，通过rs可以有效的获取数据库的字段
		 */
		User loadUser = (User) jdbcTemplate.queryForObject(sql,
				new Object[] { username }, new UserMapper());
		return loadUser;
	}

	private class UserMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			Role role = new Role();
			role.setName(rs.getString("rname"));
			role.setId(rs.getInt("rid"));
			role.setDescn(rs.getString("rdescn"));
			roles.add(role);
			
			if (!rs.getString(rs.getString("username")).equals(user.getUserName())) {//查询出来的结果是一对多，所以当是同一个用户的角色的时候就不在创建用户对象
				user.setRoles(roles);
				user.setUserName(rs.getString("username"));
				user.setId(rs.getInt("userid"));
				user.setPassword(rs.getString("password"));
				user.setStatus(rs.getInt("status"));
				user.setDescn(rs.getString("userdescn"));
			}
			return user;
		}

	}

}
