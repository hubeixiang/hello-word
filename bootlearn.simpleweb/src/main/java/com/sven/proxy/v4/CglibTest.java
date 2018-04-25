package com.sven.proxy.v4;

/**
 * Created by sven on 2017/5/18.
 */
public class CglibTest {
    public static void main(String[] args) {
        PopleTalk talk = (PopleTalk) new CglibProxy().getInstance(new PopleTalk());
        talk.talk("测试1");
        talk.speak("测试2");
    }
}
