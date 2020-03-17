package com.unimas.study.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 系统运行的启动类
 * 默认 CommandLineRunner 比 ApplicationRunner 先执行,
 *  但可以使用 @Order(2) 指定执行顺序, 数字越小的 先执行
 * @ClassName Runner01
 * @Description TODO
 * @Author 50204
 * @Date 2020/3/17 22:14
 * @Version 1.0
 **/
@Component
@Order(2)
public class Runner01 implements CommandLineRunner{
    @Override
    public void run(String... args) throws Exception {
        System.out.println(" runner 01 is running -----> ");
    }
}
