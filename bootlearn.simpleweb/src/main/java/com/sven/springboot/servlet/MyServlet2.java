package com.sven.springboot.servlet;

import com.sven.springboot.configuration.LearnProperties;
import com.sven.springboot.configuration.WiselySettings;
import com.sven.springboot.env.MyEnvironmentAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 123 on 2016/8/29.
 */
@WebServlet(urlPatterns = "/myServlet2/*", description = "Servlet的说明")
public class MyServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Value("${my.setting.v}")
    private String v;

    @Autowired
    WiselySettings wiselySettings;

    @Autowired
    LearnProperties learnProperties;

    @Autowired
    MyEnvironmentAware myEnvironmentAware;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(">>>>>>MyServlet2 DoGet>>>>>>>");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(">>>>>>MyServlet2 DoPost>>>>>>>");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>这是：MyServlet2</h1>");
        out.println(String.format("<h1>my.setting.v:%s</h1>", v));
        out.println(String.format("<h1>learn.spring.username:%s</h1>", learnProperties.getUsername()));
        out.println(String.format("<h1>wisely.properties:%s</h1>", wiselySettings.getName()));
        out.println(String.format("<h1>spring.datasource.url:%s</h1>", myEnvironmentAware.getMyUrl()));
        out.println("</body>");
        out.println("</html>");
    }
}
