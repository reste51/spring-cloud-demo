package com.imooc.ad.entity.unit_condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 推广单元的地域限制
 * @ClassName AdUnitDistrict
 * @Description TODO
 * @Author 50204
 * @Date 2020/4/8 22:24
 * @Version 1.0
 **/
@Data
@Entity
@Table(name = "ad_unit_it")
@NoArgsConstructor
@AllArgsConstructor
public class AdUnitDistrict {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Basic
    @Column(name = "unit_id",nullable = false)
    private Long unitId;

    @Basic
    @Column(name = "province",nullable = false)
    private String province;

    @Basic
    @Column(name = "city",nullable = false)
    private String city;

    public AdUnitDistrict(Long unitId, String province,String city){
        this.unitId=unitId;
        this.province = province;
        this.city = city;
    }


}
