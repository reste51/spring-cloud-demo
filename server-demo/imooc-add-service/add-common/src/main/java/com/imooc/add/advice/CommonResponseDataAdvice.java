package com.imooc.add.advice;

import com.imooc.add.annotation.IgnoreResponseAdvice;
import com.imooc.add.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 响应体返回之前做一些 自定义的处理工作
 * @ClassName CommonResponseDataAdvice
 * @Author 50204
 * @Date 2020/3/12 21:12
 * @Version 1.0
 **/
@RestControllerAdvice
public class CommonResponseDataAdvice  implements ResponseBodyAdvice<Object>{
    /**
     * 判断是否 对响应进行处理， 根据设置 自定义的注解 @IgnoreResponseAdvice来忽略处理。
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
     */
    @Nullable
    @Override
    @SuppressWarnings("all")
    public Object beforeBodyWrite(@Nullable Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        // 返回的默认结果
        CommonResponse<Object> commonResponse = new CommonResponse<>(0,"");
       // 空值 则返回 默认的空commonResponse 对象
        if(null == body){
            return  commonResponse;
        // 类型一致
        }else  if(body instanceof CommonResponse){
            commonResponse = (CommonResponse<Object>) body;
        }else{
            // 返回数据
            commonResponse.setData(body);
        }
       return null;
    }
}
