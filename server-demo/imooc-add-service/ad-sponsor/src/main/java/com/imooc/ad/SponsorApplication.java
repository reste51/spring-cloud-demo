package com.imooc.ad;/**
 * Created by DELL on 2020/3/21.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName SponsorApplication
 * @Description TODO
 * @Author DELL
 * @Date 2020/3/21 16:57
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients // 可以 调用 其他服务, dashbord 实现监控
@EnableCircuitBreaker// 断路器
public class SponsorApplication {
    public static void main(String[] args) {
        SpringApplication.run(SponsorApplication.class);
    }
}
