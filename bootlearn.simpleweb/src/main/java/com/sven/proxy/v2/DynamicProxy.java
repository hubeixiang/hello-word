package com.sven.proxy.v2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by sven on 2017/5/17.
 * jdk1.5提供的动态代理
 * 动态代理类
 */
public class DynamicProxy implements InvocationHandler {
    /**
     * 需要代理的目标类
     **/
    private Object target;

    /**
     * 写法固定,aop专用:绑定委托对象并返回一个代理类
     *
     * @param target 被代理的对象
     * @return 代理对象
     */
    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /**
     * @param proxy  被代理的对象
     * @param method 要调用的方法
     * @param args   方法调用时所需要的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        //切面执行之前
        System.out.println("切面执行之前执行");
        //执行业务,
        // ******* 注意此处invke调用的第一个参数,一定是被代理的对象,与cglib中的调用方式不一致.cglib中有两种调用方式
        result = method.invoke(target, args);
        //切面执行之后
        System.out.println("切面执行之后");
        return result;
    }

}
