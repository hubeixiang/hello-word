package com.sven.springboot.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by 123 on 2016/8/29.
 * 疑问:一次访问Filter中的doFilter会在访问开始和访问结束分别调用一次?
 * 使用注解标注过滤器
 * @WebFilter将一个实现了javax.servlet.Filter接口的类定义为过滤器
 * 属性filterName声明过滤器的名称,可选
 * 属性urlPatterns指定要过滤的URL模式,也可使用属性value来声明.(指定要过滤的URL模式是必选属性)
 * @author Angel(QQ:412887952)
 * @version v.0.1
 */
@WebFilter(filterName="myFilter",urlPatterns="/myServlet2/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(">>>>MyFilter init>>>>");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println(">>>>MyFilter doFilter>>>>");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println(">>>>MyFilter destroy>>>>");
    }
}
