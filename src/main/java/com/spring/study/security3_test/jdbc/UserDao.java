package com.spring.study.security3_test.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

public class UserDao extends MappingSqlQuery<Object> {
	
	public UserDao(DataSource dataSource, String sql) {
		super(dataSource, sql);
		this.declareParameter(new SqlParameter(Types.VARCHAR)); // sql中注入一个参数
	}

	@Override
	protected Object mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
