package com.imooc.ad.controller;

import com.imooc.ad.client.SponsorClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@Slf4j
@RestController
@RequestMapping("search")
public class SearchController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SponsorClient sponsorClient;

    @RequestMapping("getSponsorServiceData")
    public Map<String,Object> getSponsorServiceData(){
       return restTemplate.getForObject("http://eureka-client-ad-sponsor:9100/ad-sponsor/sponsor/test/hello?param=search",Map.class);
    }

    // 待使用 feign调用
    @RequestMapping("getDataByFeign")
    public Map<String,Object> getDataByFeign(@RequestParam("param")String param){
        return sponsorClient.getTestMsg(param);
    }



}
