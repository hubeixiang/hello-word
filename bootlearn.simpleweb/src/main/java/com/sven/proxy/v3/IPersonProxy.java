package com.sven.proxy.v3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author sven
 * @date 2019/11/14 14:44
 * jdk1.5提供的动态代理,必须代理的是接口
 * 动态代理
 */
public class IPersonProxy implements InvocationHandler {
	private IPerson iPerson;

	private IPersonProxy(IPerson iPerson) {
		this.iPerson = iPerson;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] params) throws Throwable {
		if (Object.class.equals(method.getDeclaringClass())) {
			return method.invoke(this, params);
		}
		if ("isFemale".equals(method.getName())) {
			Boolean isFemale = (Boolean) method.invoke(iPerson, params);
			return isFemale;
		} else if ("wife".equals(method.getName())) {
			Wife wife = (Wife) method.invoke(iPerson, params);
			return wife;
		} else if ("talk".equals(method.getName())) {
			Object stmt = method.invoke(iPerson, params);
			return stmt;
		} else {
			return method.invoke(iPerson, params);
		}
	}

	public static IPerson newInstance(IPerson iPerson) {
		InvocationHandler handler = new IPersonProxy(iPerson);
		ClassLoader classLoader = iPerson.getClass().getClassLoader();
		return (IPerson) Proxy.newProxyInstance(classLoader, new Class[] { IPerson.class }, handler);
	}
}
