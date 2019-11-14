package com.sven.proxy.v3;

/**
 * @author sven
 * @date 2019/11/14 15:19
 */
public class Person implements IPerson {
	@Override
	public boolean isFemale() {
		return false;
	}

	@Override
	public Wife wife(String name) {
		return new Wife(name);
	}

	@Override
	public void talk(String msg) {
		System.out.println(String.format("Person talk [%s]", msg));
	}
}
