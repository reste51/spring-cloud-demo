package com.imooc.ad.entity.unit_condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 推广单元的  兴趣标签
 * @ClassName AdUnitIt
 * @Description TODO
 * @Author 50204
 * @Date 2020/4/8 22:16
 * @Version 1.0
 **/
@Data
@Entity
@Table(name = "ad_unit_it")
@NoArgsConstructor
@AllArgsConstructor
public class AdUnitIt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;


    @Basic
    @Column(name = "unit_id",nullable = false)
    private Long unitId;

    @Basic
    @Column(name = "it_tag",nullable = false)
    private String itTag;

    public AdUnitIt(Long unitId, String itTag){
        this.unitId=unitId;
        this.itTag=itTag;
    }

}
