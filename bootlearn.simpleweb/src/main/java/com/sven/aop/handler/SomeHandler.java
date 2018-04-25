package com.sven.aop.handler;


import com.sven.aop.calc.Calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by sven on 2016/12/26.
 */
public class SomeHandler implements InvocationHandler {
    private Object target;
    public SomeHandler(Calculator calc){
        super();
        this.target = calc;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] params) throws Throwable {
        System.out.println("before ...... ");
        if (method.getName().equalsIgnoreCase("calculate")) {
            Object result = method.invoke(target, params);
            System.out.println("after ...... ");
            return result;
        } else {
            System.out.println("method is not matchers!");
            return null;
        }
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(), this);
    }
}
