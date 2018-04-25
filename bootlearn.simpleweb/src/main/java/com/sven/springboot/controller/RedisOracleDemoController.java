package com.sven.springboot.controller;

import com.sven.springboot.db.entity.OracleTestDemo;
import com.sven.springboot.db.service.IRedisOracleTestDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 123 on 2016/8/30.
 */
@Controller
@RequestMapping("/redis")
public class RedisOracleDemoController {
    @Autowired
    IRedisOracleTestDemoService iRedisOracleTestDemoService;

    @RequestMapping("/test")
    public
    @ResponseBody
    String test() {
        OracleTestDemo loaded = iRedisOracleTestDemoService.findById(1);
        System.out.println("loaded=" + loaded);
        OracleTestDemo cached = iRedisOracleTestDemoService.findById(1);
        System.out.println("cached=" + cached);
        loaded = iRedisOracleTestDemoService.findById(2);
        System.out.println("loaded2=" + loaded);
        return "ok";
    }


    @RequestMapping("/delete")
    public
    @ResponseBody
    String delete(long id) {
        iRedisOracleTestDemoService.deleteFromCache(id);
        return "ok";
    }

    @RequestMapping("/test1")
    public
    @ResponseBody
    String test1() {
        iRedisOracleTestDemoService.test();
        System.out.println("DemoInfoController.test1()");
        return "ok";
    }
}
