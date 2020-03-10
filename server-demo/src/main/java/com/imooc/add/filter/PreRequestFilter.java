package com.imooc.add.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 前置过滤器
 * 1. 记录请求前的 时间
 * @ClassName PreRequestFilter
 * @Description TODO
 * @Author 50204
 * @Date 2020/3/9 22:59
 * @Version 1.0
 **/
@Slf4j
@Component
public class PreRequestFilter  extends ZuulFilter {
    @Override
    public String filterType() {
        return  "";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
