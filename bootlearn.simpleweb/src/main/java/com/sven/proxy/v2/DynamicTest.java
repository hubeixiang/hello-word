package com.sven.proxy.v2;

import com.sven.proxy.v1.ITalk;
import com.sven.proxy.v1.PopleTalk;

/**
 * Created by sven on 2017/5/17.
 */
public class DynamicTest {
    public static void main(String[] args) {
        //绑定代理,这种方式会在所有的方法上面都加上切面方法
        ITalk iTalk = (ITalk) new DynamicProxy().bind(new PopleTalk());
        iTalk.talk("动态代理");

        System.out.println("main-----------------------");

        iTalk.eat();
    }
}
