package com.sven.proxy.v5;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by sven on 2017/5/18.
 * 使用cglib包创建代理
 */
public class CglibProxy implements MethodInterceptor {
    private Object target;

    /**
     * 创建代理对象
     *
     * @param target
     * @return
     */
    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        //设置代理对象的父类,可以看到代理对象是目标对象的子类。所以这个接口类就可以省略了
        enhancer.setSuperclass(this.target.getClass());
        //回调方法,拦截器
        enhancer.setCallback(this);
        //创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object result = null;
        System.out.println("业务开始");
        //下面这两种方式都是可以的.与jdk动态代理中的方式不一致。jdk动态代理中只有一种方式
        result = methodProxy.invokeSuper(proxy, args);
//        result = method.invoke(this.target, args);
        System.out.println("业务结束");
        return result;
    }
}
