package com.imooc.ad.controller;

import com.imooc.ad.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName SponsorController
 * @Description TODO
 * @Author DELL
 * @Date 2020/4/25 16:03
 * @Version 1.0
 **/
@RestController
@RequestMapping("/sponsor/test")
public class SponsorController {

    @Autowired
    private HelloService helloService;

    @GetMapping("hello")
    public Map<String,Object> getTestMsg(@RequestParam("param")String param){
        Map<String,Object> ret = new HashMap<>();
        ret.put("success",true);
        ret.put("newMsg","sponsor" + param);
        ret.put("data", helloService.getAll());
        return ret;
    }
}
