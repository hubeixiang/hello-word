package com.sven.proxy.v1;

/**
 * Created by sven on 2017/5/17.
 */
public class PopleTalk implements ITalk {
    private String username;
    private String age;

    public PopleTalk() {

    }

    public PopleTalk(String username, String age) {
        this.username = username;
        this.age = age;
    }

    @Override
    public void talk(String msg) {
        System.out.println(String.format("%s!你好,我是%s,我年龄是%s", msg, username, age));
    }

    @Override
    public void eat() {
        System.out.println("吃饭");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
