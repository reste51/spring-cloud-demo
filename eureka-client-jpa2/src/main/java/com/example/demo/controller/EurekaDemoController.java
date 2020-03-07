package com.example.demo.controller;/**
 * Created by DELL on 2020/3/7.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Eureka client 测试方法
 * @ClassName EurekaDemoController
 * @Description TODO
 * @Author DELL
 * @Date 2020/3/7 12:23
 * @Version 1.0
 **/
@Controller
public class EurekaDemoController {
    @Autowired
    private DiscoveryClient discoveryClient;

    /***
     * 获取客户端的 实例
     * @return
     */
    @RequestMapping("index2")
    @ResponseBody
    public List<ServiceInstance> getRegister(){
        return  discoveryClient.getInstances("eureka-client");
    }

}
