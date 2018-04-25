package com.sven.proxy.v1;

/**
 * Created by sven on 2017/5/17.
 */
public class ProxyPattern {
    public static void main(String[] args) {
        ITalk pople = new PopleTalk("AOP", "19");
        pople.talk("no proxy test");
        pople.eat();

        System.out.println("-----------------------------------");

        //需要执行额外的方法,切面
        TalkProxy proxy = new TalkProxy(pople);
        proxy.talk("Proxy Test", "代理");
        proxy.eat();
    }
}
