package com.sven.springboot.servlet;

import com.sven.springboot.autoconfiguration.SpringContextUtil;
import com.sven.springboot.configuration.LearnProperties;
import com.sven.springboot.configuration.WiselySettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 123 on 2016/8/29.
 * 普通类,不能直接使用Autowired注解,需要使用Service
 */
public class MyServlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Autowired
    WiselySettings wiselySettings;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(">>>>>>MyServlet1 DoGet>>>>>>>");
        createHtml(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(">>>>>>MyServlet1 DoPost>>>>>>>");
        createHtml(req, resp);
    }

    private void createHtml(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
//        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>这是：MyServlet1</h1>");
        out.println(String.format("<h1>wisely.properties:%s</h1>", wiselySettings != null ? wiselySettings.getName() : "未初始化wiselySettings"));
        out.println("</body>");
        out.println("</html>");
    }
}
