package com.sven.proxy.v3;

/**
 * @author sven
 * @date 2019/11/14 15:15
 */
public interface IPerson {

	public boolean isFemale();

	public Wife wife(String name);

	public void talk(String msg);
}
