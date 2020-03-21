package com.imooc.ad.entity;

import com.imooc.ad.constant.CommonStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 推广单元
 * @ClassName AdUnit
 * @Description TODO
 * @Author DELL
 * @Date 2020/3/21 21:00
 * @Version 1.0
 **/
@Data
@Entity
@Table(name = "ad_unit")
public class AdUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long planId;

    private  String unitName;
    private  Integer unitStatus;
    /**
        投放广告位的类型( 开屏/ 贴片/ 中贴.... )
      */
    private Integer positionType;

    // 广告预算
    private Double budget;

    private Date createTime;
    private Date updateTime;

    public AdUnit(Long planId,String unitName,
                  Integer positionType,Double budget){
        this.planId = planId;
        this.unitName = unitName;
        this.positionType=positionType;
        this.budget = budget;
        // 默认为 有效
        this.unitStatus = CommonStatus.VALID.getCode();

        this.createTime = new Date();
        this.updateTime = this.createTime;
    }
}
