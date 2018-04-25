package com.sven.springboot.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by 123 on 2016/8/29.
 * 实际应用中，我们会有在项目服务启动的时候就去加载一些数据或做一些事情这样的需求。
 * 为了解决这样的问题，Spring Boot 为我们提供了一个方法，通过实现接口 CommandLineRunner 来实现
 * Spring Boot应用程序在启动后，会遍历CommandLineRunner接口的实例并运行它们的run方法。
 * 也可以利用@Order注解（或者实现Order接口）来规定所有CommandLineRunner实例的运行顺序
 */
@Component
@Order(value = 2)
public class MyStartupRunner2 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println(Arrays.asList(args) + ">>>>>>MyStartupRunner2>>>>>>>>>服务启动执行，执行加载数据等操作<<<<<<<<<<<<<");
    }
}
