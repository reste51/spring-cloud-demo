package com.imooc.add.vo;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 统一响应类
 * @ClassName CommonResponse
 * @Description TODO
 * @Author 50204
 * @Date 2020/3/11 21:23
 * @Version 1.0
 **/
@Data
@AllArgsConstructor //所有参数的 构造
@NoArgsConstructor  // 无参的构造
public class CommonResponse<T> implements Serializable {
    private Integer code;
    private  String message;
    private T data;

    public CommonResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
