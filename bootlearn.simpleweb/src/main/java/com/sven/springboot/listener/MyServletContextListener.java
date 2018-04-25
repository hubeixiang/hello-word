package com.sven.springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by 123 on 2016/8/29.
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println(">>>>MyServletContextListener init>>>>");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println(">>>>MyServletContextListener destoryed>>>>");
    }
}
