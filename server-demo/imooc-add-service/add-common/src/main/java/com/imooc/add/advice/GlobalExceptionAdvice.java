package com.imooc.add.advice;/**
 * Created by 50204 on 2020/3/17.
 */

import com.imooc.add.exception.AddException;
import com.imooc.add.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName GlobalExceptionAdvice
 * @Description TODO
 * @Author 50204
 * @Date 2020/3/17 10:13
 * @Version 1.0
 **/
@RestControllerAdvice
public class GlobalExceptionAdvice {
    /**
     *  统一异常的处理
     *  抛出AddException的拦截器 方法
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(value = AddException.class)
    public CommonResponse<String> handlerAddException(HttpServletRequest request,
                                                      AddException ex){
        CommonResponse<String> commonResponse = new CommonResponse<>(-1,"business error!");
        // 获取 异常的消息并返回
        commonResponse.setData(ex.getMessage());

        return  commonResponse;
    }

}
