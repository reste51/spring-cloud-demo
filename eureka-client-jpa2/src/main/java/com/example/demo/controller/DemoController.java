package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * controller类
 * @ClassName DemoController
 * @Description TODO
 * @Author 50204
 * @Date 2020/3/3 22:24
 * @Version 1.0
 **/
@Controller
public class DemoController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello world";
    }
    /**
         注: 返回的数据 使用 @ResponseBody注解
         替代了  response.write()
      */
    @RequestMapping("/list")
    @ResponseBody
    public List<String> list(){
        List<String> resp =  new ArrayList<String>();
        resp.add("Hello");
        resp.add("world");
        return resp;
    }
}
