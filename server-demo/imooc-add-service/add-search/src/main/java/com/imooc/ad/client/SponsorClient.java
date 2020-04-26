package com.imooc.ad.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 使用feign调用sponsor的服务
 * spring.app.name 的值
 */
@FeignClient(value = "eureka-client-ad-sponsor")
public interface SponsorClient {

    /**
     * 请求路径和 sponsorController的 请求全路径一样, class和 method
     */
    @RequestMapping("ad-sponsor/sponsor/test/hello")
    Map<String,Object> getTestMsg(@RequestParam("param")String param);

}
