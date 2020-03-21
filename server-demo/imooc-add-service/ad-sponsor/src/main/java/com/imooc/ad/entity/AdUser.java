package com.imooc.ad.entity;/**
 * Created by DELL on 2020/3/21.
 */

import com.imooc.ad.constant.CommonStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @ClassName AdUser
 * @Description TODO
 * @Author DELL
 * @Date 2020/3/21 17:02
 * @Version 1.0
 **/
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ad_user")
public class AdUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name",nullable = false)
    @Basic
    private String userName;
    @Basic
    private String token;

    @Column(name = "user_status",nullable = false)
    @Basic
    private Integer userStatus;

    private Date createTime;
    private Date updateTime;

    public AdUser (String userName, String token){
        this.userName=userName;
        this.token = token;
        // 默认为 有效的
        this.userStatus = CommonStatus.VALID.getCode();
        this.createTime = new Date();
        this.updateTime = this.createTime;
    }

}
