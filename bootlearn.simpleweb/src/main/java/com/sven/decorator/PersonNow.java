package com.sven.decorator;

/**
 * Created by sven on 2017/5/17.
 * * 装饰类
 * (要去增强目标对象的类)
 * 装饰类通常会通过构造方法接收被装饰的对象。
 * 并基于被装饰的对象的功能，提供更强的功能。
 * <p/>
 * 装饰对象与 被装饰对象都是实现相同的接口,而且装饰对象中需要含有被装饰对象的引用
 */
public class PersonNow implements Person {
    private Person person;

    public PersonNow(Person person) {
        this.person = person;
    }

    @Override
    public void eat() {
        System.out.println("开胃酒");
        person.eat();
        System.out.println("甜点");
        System.out.println("来一根烟");
    }
}
