package com.imooc.ad.entity;

import com.imooc.ad.constant.CommonStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * 推广计划
 * @ClassName AdPlane
 * @Description TODO
 * @Author DELL
 * @Date 2020/3/21 20:40
 * @Version 1.0
 **/
@Data
@Entity
@Table(name = "ad_plan")
@AllArgsConstructor
@NoArgsConstructor
public class AdPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private Long userId;
    private  String planName;
    private  Integer planStatus;

    private Date startDate;
    private  Date endDate;
    private  Date createTime;

    /**
     * 推广计划
     * @param userId
     * @param planName
     * @param startDate
     * @param endDate
     */
    public AdPlan(Long userId,String planName,Date startDate,Date endDate){
        this.userId = userId;
        this.planName = planName;
        this.planStatus = CommonStatus.VALID.getCode();

        this.startDate =startDate;
        this.endDate = endDate;
        this.createTime = new Date();
    }


}
