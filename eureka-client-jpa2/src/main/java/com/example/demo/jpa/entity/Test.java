package com.example.demo.jpa.entity;/**
 * Created by 50204 on 2020/3/4.
 */

import lombok.Data;

import javax.persistence.*;

/**
 * jpa的 实体类
 * @ClassName Test
 * @Description TODO
 * @Author 50204
 * @Date 2020/3/4 22:14
 * @Version 1.0
 *
 * @Data 为 lombook插件，无需使用 getter和setter方法.
 **/
@Entity
@Table(name = "test1")
@Data
public class Test {
    @Id
    @GeneratedValue(generator = "uuid",strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private Integer age;
    //1为有效，0 为无效
    private Integer status;
}
