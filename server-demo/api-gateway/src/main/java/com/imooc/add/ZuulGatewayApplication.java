package com.imooc.add;/**
 * Created by 50204 on 2020/3/9.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * zuul 路由的启动类
 * @ClassName ZuulGatewayApplication
 * @Description TODO
 * @Author 50204
 * @Date 2020/3/9 22:46
 * @Version 1.0
 **/
@EnableZuulProxy
@SpringBootApplication
public class ZuulGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApplication.class,args);
    }
}
