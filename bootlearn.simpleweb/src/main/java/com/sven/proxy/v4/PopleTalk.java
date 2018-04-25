package com.sven.proxy.v4;

/**
 * Created by sven on 2017/5/17.
 * 业务类
 */
public class PopleTalk {
    public void talk(String msg) {
        System.out.println(String.format("cglib pople talk: %s", msg));
    }

    public void speak(String msg) {
        System.out.println(String.format("cglib pople speak: %s", msg));
    }
}
