package com.imooc.add.exception;/**
 * Created by 50204 on 2020/3/17.
 */

/** 自定义 异常类
 * @ClassName AddException
 * @Description TODO
 * @Author 50204
 * @Date 2020/3/17 10:10
 * @Version 1.0
 **/
public class AddException extends  Exception{
    // 设置 返回的消息
    public AddException(String msg) {
        super(msg);
    }
}
