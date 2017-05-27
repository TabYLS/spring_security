package com.spring.study.security3;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.spring.study.dao.IUserDao;
import com.spring.study.domain.Role;

/**
 * authentication-provider的实现
 * 
 * @author YLS
 *
 */
public class MyUserDetailService implements UserDetailsService {
	
	@Resource(name = "userJdbcDao")
	private IUserDao userJdbcDao;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		/*
		 * Collection<GrantedAuthority> auths = new
		 * ArrayList<GrantedAuthority>(); SimpleGrantedAuthority auth2 = new
		 * SimpleGrantedAuthority("ROLE_ADMIN"); auths.add(auth2);
		 * 
		 * if (username.equals("admin")) { auths = new
		 * ArrayList<GrantedAuthority>(); SimpleGrantedAuthority auth1 = new
		 * SimpleGrantedAuthority("ROLE_ADMIN"); auths.add(auth1); }
		 * 
		 * User user = new User(username, "admin", true,true,true,true,auths);
		 */
	//	IUserDao userJdbcDao = new UserDao();
		com.spring.study.domain.User myuser = userJdbcDao.load(username);
		String password = myuser.getPassword();
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		for (Role role : myuser.getRoles()) {//获取用户的所有权限
			GrantedAuthority auth = new SimpleGrantedAuthority(role.getName());
			auths.add(auth);
		}

		User user = new User(username, password, true, true, true, true, auths);
		return user;
	}

}
