/*package com.spring.study.security3_test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;

public class MyInvocationSecurityMetadataSourceService implements
		FilterInvocationSecurityMetadataSource {

	// @Resource(name = "testDao")
	@Autowired
	private TestDao testDao;

	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	public MyInvocationSecurityMetadataSourceService(TestDao testDao) {
		// 使用注解方式的话，只能在构造函数执行完成后才能获得实例
		this.testDao = testDao;
		loadResourceDefine();
	}

	// 在Web服务器启动时，提取系统中的所有权限
	private void loadResourceDefine() {
		List<String> query = this.testDao.getAllAuthorityName();

		
		 * 应当是资源为key， 权限为value。 资源通常为url， 权限就是那些以ROLE_为前缀的角色。 一个资源可以由多个权限来访问。
		 * sparta
		 
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();

		for (String auth : query) {
			ConfigAttribute ca = new SecurityConfig(auth);

			List<String> query1 = this.testDao.getResource(auth);

			for (String res : query1) {
				String url = res;

				
				 * 判断资源文件和权限的对应关系，如果已经存在相关的资源url，则要通过该url为key提取出权限集合，将权限增加到权限集合中。
				 * sparta
				 
				if (resourceMap.containsKey(url)) {
					Collection<ConfigAttribute> value = resourceMap.get(url);
					value.add(ca);
					resourceMap.put(url, value);
				} else {
					Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
					atts.add(ca);
					resourceMap.put(url, atts);
				}
			}

		}

	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {

		return null;
	}

	// 根据URL，找到相关的权限配置。
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {

		// object 是一个URL，被用户请求的url。
		String url = ((FilterInvocation) object).getRequestUrl();
		System.out.println("url" + url);
		int firstQuestionMarkIndex = url.indexOf("?");

		if (firstQuestionMarkIndex != -1) {
			url = url.substring(0, firstQuestionMarkIndex);
		}

		Iterator<String> ite = resourceMap.keySet().iterator();

		while (ite.hasNext()) {
			String resURL = ite.next();

			if (url.equals(resURL)) {

				return resourceMap.get(resURL);
			}
		}

		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {

		return true;
	}

}*/