package com.sven.springboot.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by 123 on 2016/8/29.
 */
//@WebListener //必能再次添加,在Application.java中手动注册了此Listener
public class MyHttpSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println(">>>>MyHttpSessionListener init>>>>");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println(">>>>MyHttpSessionListener destoryed>>>>");
    }
}
