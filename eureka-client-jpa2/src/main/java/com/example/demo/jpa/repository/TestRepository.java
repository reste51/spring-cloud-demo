package com.example.demo.jpa.repository;

import com.example.demo.jpa.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Dao数据访问层
 * Created by 50204 on 2020/3/4.
 *
 * 泛型1： 为实体类对象, 2 为主键的类型
 */
public interface TestRepository  extends JpaRepository<Test,String>{


    List<Test> findByStatus(Integer status);

}
