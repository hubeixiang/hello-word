package com.sven.springboot.controller;

/**
 * Created by 123 on 2016/8/27.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/template")
public class TemplateController {

    /**
     * 返回html模板.
     */
    @RequestMapping("/helloHtml")
    public String helloHtml(Map<String, Object> map) {
        map.put("hello", "from TemplateController.helloHtml devtools reload reload  error");
        return "/helloHtml";
    }

    /**
     * 返回html模板.
     */
    @RequestMapping("/testEcmaScript5")
//    public String testEcmaScript5(Map<String, Object> map) {
//        map.put("hello", "from TemplateController.testEcmaScript5 devtools reload reload  error");
//        return "helloHtml";
//        return "testEcmaScript5";
//    }
    public String testEcmaScript5(Model model){
        model.addAttribute("hello","Model from TemplateController.testEcmaScript5 devtools reload reload  error");
//        map.put("hello", "from TemplateController.testEcmaScript5 devtools reload reload  error");
        //return "helloHtml";
        return "testEcmaScript5";
    }
}
