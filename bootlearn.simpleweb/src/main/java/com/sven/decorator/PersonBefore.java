package com.sven.decorator;

/**
 * Created by sven on 2017/5/17.
 * 实现的对象,专注的功能吃饭,也是被装饰的对象
 */
public class PersonBefore implements Person {
    @Override
    public void eat() {
        System.out.println("吃饭");
    }
}
