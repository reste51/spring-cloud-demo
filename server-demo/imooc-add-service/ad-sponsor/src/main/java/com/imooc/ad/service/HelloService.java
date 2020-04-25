package com.imooc.ad.service;/**
 * Created by DELL on 2020/4/25.
 */

import com.imooc.ad.entity.HelloEntity;
import com.imooc.ad.repository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName HelloService
 * @Description TODO
 * @Author DELL
 * @Date 2020/4/25 17:36
 * @Version 1.0
 **/
@Service
public class HelloService {
    @Autowired
    private HelloRepository helloRepository;

    public List<HelloEntity> getAll(){
       return  helloRepository.findAll();
    }
}
