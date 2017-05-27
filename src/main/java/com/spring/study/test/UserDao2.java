/*package com.spring.study.test;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.support.JdbcDaoSupport;  
import org.springframework.stereotype.Repository;  

*//**
 * 使用JdbcDaoSuport
 * @author YLS
 *
 *//*
@Repository  
public class UserDao2 extends JdbcDaoSupport{  
  
    @Autowired  
    public void setTemplate(JdbcTemplate template) {  
        setJdbcTemplate(template);  
    }  
  
      
    public User getUserById(int userId){  
        String sql = " select * from User where id = ? ";  
        return getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<>(User.class), userId);  
    }  
      
}  */