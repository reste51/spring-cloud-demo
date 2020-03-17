package com.imooc.add.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 统一消息转化器
 * @ClassName WebConfiguration
 * @Description TODO
 * @Author 50204
 * @Date 2020/3/17 10:59
 * @Version 1.0
 **/
@Configuration
public class WebConfiguration implements WebMvcConfigurer{
    /**
     * 消息转化
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.clear();
        // java --> json，  http头: application/json
        converters.add(new MappingJackson2HttpMessageConverter());
    }
}
