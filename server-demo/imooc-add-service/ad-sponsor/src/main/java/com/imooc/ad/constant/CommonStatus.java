package com.imooc.ad.constant;

import lombok.Getter;

/**
    通用状态的 常量
 */
@Getter
public enum CommonStatus {
    // 两个实例
    VALID(1,"有效状态"),
    INVALID(2,"无效状态");

    private Integer code;
    private String desc;

    CommonStatus(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }



}
