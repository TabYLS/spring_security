/*package com.spring.study.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	*//**
	 * Spring JdbcTemplate/JdbcDaoSupport
	 * 建议使用JdbcTemplate，因为JdbcDaoSuport其实调用的还是jdbctemplate的方法 只是集成
	 * JDBCDaoSupport 需要再次DI 它的DataSource或者jdbctemplate 步骤：
	 * 1、在spring的xml中，配置jdbctemplate，依赖于数据源，所以需要见一个数据源bean <bean
	 * id="jdbcTemplate"
	 * class="org.springframework.jdbc.core.JdbcTemplate"><property
	 * name="dataSource" ref="dataSource"></property> </bean>
	 * 
	 * 2、通过注入的jdbctemplate做增删改查操作 2.1 增删改：jdbcTemplate.update(sql,args);
	 * (PS:批量增加使用 jdbcTemplate.update(sql,List<Object[]>);) 2.2 查找返回一个值
	 * 采用queryForObject(String sql, Class<?> requiredType) 例如返回几多条记录，会用到这个 2.3
	 * 查找返回一个对象 采用queryForObject(String sql, RowMapper<User> rowMapper)
	 * 需要传入RowMapper对象 new BeanPropertyRowMapper<>(Class<?>); 2.4 获取多个对象
	 * 采用query(String sql, RowMapper<Class<?>> rowMapper) 需要传入RowMapper对象
	 * RowMapper<User> userMapper = new BeanPropertyRowMapper<>(User.class);
	 * 
	 * 3、使用JdbcDaoSupport 3.1 使用类集成JdbcDaoSupport 3.2
	 * 需要额外注入datasource或者jdbctemplate，可以参考userdao2;
	 * 
	 * 4、额外知识（使用具名参数 NamedParameterJdbcTemplate） 4.1 NamedParameterJdbcTemplate
	 * 配置bean时需要用构造方法传入datasource 4.2 将我们平时用？问号的占位符 改成冒号 （:字段名） 的形式做占位符 4.3 用map
	 * 键值的形式传入参数（这个日后用bean来设置将非常方便）
	 * 
	 * @param args
	 *//*

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		UserDao userDao = ctx.getBean(UserDao.class);
		UserDao2 userDao2 = ctx.getBean(UserDao2.class);

		// 增加
		// int row = userDao.addUser(new User(0, "Flash", 2));
		// System.out.println("row == "+row);

		// 修改
		int row = userDao.updateUser(new User(2, "Flash", 1));
		System.out.println(row);

		// 返回一个列值
		long count = userDao.getUserCount();
		System.out.println("count == " + count);

		// 查找一个对象
		User user = userDao.getUserById(1);
		System.out.println("user == " + user);

		// 查找多个对象
		List<User> lists = userDao.getUsers();
		System.out.println("lists == " + lists);

		// ======JdbcDaoSupport===========

		User user2 = userDao2.getUserById(2);
		System.out.println(user2);

		// ==========NamedParameterJDBCTemplate=====================
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("userId", 2);
		User user3 = userDao.getUserByNamedParameter(paramMap);
		System.out.println(user3);
	}
}*/