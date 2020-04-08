package com.imooc.ad.entity.unit_condition;/**
 * Created by 50204 on 2020/4/8.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;

/**
 * 推广单元的  关键字
 * @ClassName AdUnitKeyword
 * @Description TODO
 * @Author 50204
 * @Date 2020/4/8 22:10
 * @Version 1.0
 **/
@Data
@Entity
@Table(name = "ad_unit_keyword")
@NoArgsConstructor
@AllArgsConstructor
public class AdUnitKeyword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;


    @Basic
    @Column(name = "unit_id",nullable = false)
    private Long unitId;

    @Basic
    @Column(name = "keyword",nullable = false)
    private String keyword;

    public AdUnitKeyword(Long unitId, String keyword){
        this.unitId=unitId;
        this.keyword=keyword;
    }





}
