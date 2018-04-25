package com.sven.proxy.v3;

/**
 * Created by sven on 2017/5/17.
 */
public class SpringCglibTest {
    public static void main(String[] args) {
        PopleTalk popleTalk = (PopleTalk) new SpringCglibProxy().getInstance(new PopleTalk());
        popleTalk.talk("业务逻辑");
        popleTalk.speak("业务逻辑");
    }
}
