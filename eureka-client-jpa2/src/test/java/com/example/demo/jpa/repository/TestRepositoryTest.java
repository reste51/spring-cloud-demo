package com.example.demo.jpa.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * 测试 dao类的方法
 * Created by 50204 on 2020/3/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRepositoryTest {
    @Autowired
    private TestRepository testRepository;

    @Test
    public void getAllDatas(){
        List<com.example.demo.jpa.entity.Test> datas = testRepository.findAll();
        System.out.println(datas);
    }

    @Test
    public void findByStatus(){
        List<com.example.demo.jpa.entity.Test> datas = testRepository.findByStatus(1);
        Assert.assertTrue( datas.size() ==1);

        System.out.println(datas);
    }

}