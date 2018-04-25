package com.sven.springboot.controller.rest;

import com.sven.springboot.db.entity.OracleTestDemo;
import com.sven.springboot.db.service.IOracleTestDemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by 123 on 2016/8/13.
 */
@RestController
@RequestMapping("/jpatest")
public class JpaController {
    @Resource
    private IOracleTestDemoService ioracleTestDemoService;

    /**
     * 测试保存数据方法.
     *
     * @return
     */
    @RequestMapping("/save")
    public String save() {
        OracleTestDemo d = new OracleTestDemo();
        d.setId(1L);
        d.setName("Angel");
        ioracleTestDemoService.save(d);//保存数据.
        return "ok.Demo2Controller.save";
    }
}
