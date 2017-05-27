/*package com.spring.study.security3_test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;

public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	@Resource(name = "testDao")
	private TestDao testDao;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		System.out.println("username" + username);
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		List<String> authorityName = this.testDao.getAuthorityName(username);
		for (String roleName : authorityName) {
			System.out.println(roleName);
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(
					roleName);
			auths.add(authority);
		}
		String pwd = this.testDao.getPWD(username);
		return new User(username, pwd, true, true, true, true, auths);

	}

}*/