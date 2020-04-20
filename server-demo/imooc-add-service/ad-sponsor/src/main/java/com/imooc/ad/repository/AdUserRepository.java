package com.imooc.ad.repository;

import com.imooc.ad.entity.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName AdUserRepository
 * @Description TODO
 * @Author 50204
 * @Date 2020/4/19 19:48
 * @Version 1.0
 **/
public interface AdUserRepository extends JpaRepository<AdUser,Long>{
    public AdUser findByUserName(String username);
}
