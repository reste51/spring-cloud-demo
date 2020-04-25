package com.imooc.ad.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @ClassName SearchController
 * @Description TODO
 * @Author DELL
 * @Date 2020/4/25 17:41
 * @Version 1.0
 **/
@RestController
@Slf4j
@RequestMapping("search")
public class SearchController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("getSponsorServiceData")
    public Map<String,Object> getSponsorServiceData(){
       return restTemplate.getForObject("http://localhost:9100/ad-sponsor/sponsor/test/hello?param=search",Map.class);
    }

}
