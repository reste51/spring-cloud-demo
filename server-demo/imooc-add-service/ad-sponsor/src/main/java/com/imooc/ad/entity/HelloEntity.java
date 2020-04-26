package com.imooc.ad.entity;/**
 * Created by DELL on 2020/4/25.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @ClassName HelloEntity
 * @Description TODO
 * @Author DELL
 * @Date 2020/4/25 17:34
 * @Version 1.0
 **/
@Table(name = "test1")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HelloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer age;
    private Integer status;
}
