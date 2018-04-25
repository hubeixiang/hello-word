package com.sven.springboot.controller.rest;

import com.sven.springboot.model.ResultInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by 123 on 2016/8/12.
 */
@RestController
@RequestMapping("/sayhello")
public class SayHelloController {

    @RequestMapping("hello.do")
    public ResultInfo sayHello() {
        ResultInfo info = new ResultInfo();
        info.setCode(1);
        info.setMessage("Hello World!");
        info.setTimestamp(new Date());
        System.out.println(info);
        System.out.println("------------");
        return info;
    }

    @RequestMapping("div.do")
    public int zero(int d) {
        return 100 / d;
    }
}
