package com.imooc.ad.repository;

import com.imooc.ad.entity.HelloEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by DELL on 2020/4/25.
 */
public interface HelloRepository extends JpaRepository<HelloEntity,Long> {
}
