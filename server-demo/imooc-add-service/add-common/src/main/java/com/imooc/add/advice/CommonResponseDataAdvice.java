package com.imooc.add.advice;

import com.imooc.add.annotation.IgnoreResponseAdvice;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 通用数据的响应类
 * @ClassName CommonResponseDataAdvice
 * @Description TODO
 * @Author 50204
 * @Date 2020/3/12 21:12
 * @Version 1.0
 **/
@RestControllerAdvice
public class CommonResponseDataAdvice  implements ResponseBodyAdvice<Object>{
    /**
     * 判断是否 对响应进行处理
     * true 需要， false不需要
     */
    @Override
    public boolean supports(MethodParameter methodType, Class<? extends HttpMessageConverter<?>> converterType) {
       //  如果该方法或 类 修饰了 该注解, 则不处理
       boolean isClassed = methodType.getDeclaringClass().
                isAnnotationPresent(IgnoreResponseAdvice.class);
       if(isClassed) return false;

       boolean isMethod = methodType.getMethod().
                isAnnotationPresent(IgnoreResponseAdvice.class);
       if(isMethod) return false;


       return false;
    }

    /**
     * 写入 响应之前 做的操作
     * @param body
     * @param returnType
     * @param selectedContentType
     * @param selectedConverterType
     * @param request
     * @param response
     * @return
     */
    @Nullable
    @Override
    public Object beforeBodyWrite(@Nullable Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        return null;
    }
}
