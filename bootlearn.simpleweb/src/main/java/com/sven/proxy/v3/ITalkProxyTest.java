package com.sven.proxy.v3;

/**
 * @author sven
 * @date 2019/11/14 14:49
 */
public class ITalkProxyTest {
	public static void main(String[] args) {
		Person person = new Person();
		IPerson iPerson = IPersonProxy.newInstance(person);
		System.out.println(iPerson.isFemale());
		System.out.println(iPerson.wife("alex"));
		iPerson.talk("fuck");
	}
}
