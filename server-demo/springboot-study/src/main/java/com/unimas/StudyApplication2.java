package com.unimas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * EnableScheduling 注解 是开启启动定时任务
 * soring boot 的学习启动类
 * @ClassName StudyApplication
 * @Description TODO
 * @Author 50204
 * @Date 2020/3/17 22:12
 * @Version 1.0
 **/
@SpringBootApplication
@EnableScheduling
public class StudyApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(StudyApplication2.class,args);
    }
}
