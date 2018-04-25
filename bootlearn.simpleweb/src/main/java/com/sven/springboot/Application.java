package com.sven.springboot;

import com.sven.springboot.interceptor.MyInterceptor;
import com.sven.springboot.listener.MyHttpSessionListener;
import com.sven.springboot.scheduling.AutowiringSchedulerFactoryBean;
import com.sven.springboot.servlet.MyServlet1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletListenerRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by 123 on 2016/8/12.
 */
@ServletComponentScan
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Order(Ordered.LOWEST_PRECEDENCE)
    @Bean
    public AutowiringSchedulerFactoryBean scheduler() {
        return new AutowiringSchedulerFactoryBean();
    }

    @Order(Ordered.LOWEST_PRECEDENCE)
    @Bean
    public ServletRegistrationBean MyServlet1() {
        //不能使用SpringContextUtil 进行获取,因为获取的值为null
//        MyServlet1 myServlet1 = SpringContextUtil.getBean(MyServlet1.class);
        //如果直接使用new的方式,就不能在MyServlet1中使用自动注解,因为自动注解的只能在Spring管理的Bean中使用
        MyServlet1 myServlet1 = new MyServlet1();
        return new ServletRegistrationBean(myServlet1, "/myServlet1/*");
    }

    @Bean
    public ServletListenerRegistrationBean MyHttpSessionListener() {
        return new ServletListenerRegistrationBean(new MyHttpSessionListener());
    }

    @Configuration
    public static class WebMvcConfig extends WebMvcConfigurerAdapter {
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            // 多个拦截器组成一个拦截器链
            // addPathPatterns 用于添加拦截规则
            // excludePathPatterns 用户排除拦截
//            registry.addInterceptor(new MyInterceptor());
            registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
            super.addInterceptors(registry);
        }
    }
}