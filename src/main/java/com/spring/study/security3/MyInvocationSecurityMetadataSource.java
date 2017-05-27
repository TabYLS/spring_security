package com.spring.study.security3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

/**
 * 对于资源的访问权限的定义，我们通过实现FilterInvocationSecurityMetadataSource这个接口来初始化数据
 * 此类在初始化时，应该取到所有资源及其对应角色的定义
 * @author YLS
 *
 */
public class MyInvocationSecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource {
	
	private static Map<String,Collection<ConfigAttribute>> resourceMap = null;
	
	public MyInvocationSecurityMetadataSource() {
		loadResourceDefine();
	}

	private void loadResourceDefine() {
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
        Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
        
        ConfigAttribute ca = new SecurityConfig("ROLE_ADMIN");
        ConfigAttribute ca1 = new SecurityConfig("ROLE_USER");
        ConfigAttribute ca2 = new SecurityConfig("ROLE_YLS");
        ConfigAttribute ca3 = new SecurityConfig("ROLE_SOCIAL");
        
        atts.add(ca);
        atts.add(ca1);
        atts.add(ca2);
        atts.add(ca3);
        //resourceMap.put("user", atts);
        resourceMap.put("/user/admin", atts);
        resourceMap.put("/hello/goto-post",atts);
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		String url = ((FilterInvocation)object).getRequestUrl();
        Iterator<String> ite = resourceMap.keySet().iterator();
        while(ite.hasNext()){
            String resURL = ite.next();
            if(url.equalsIgnoreCase(resURL)){
                return resourceMap.get(resURL);
            }
        }
		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
	}

}
