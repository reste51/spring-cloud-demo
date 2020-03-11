package com.imooc.add.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * 前置过滤器
 *  记录请求前的 时间
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
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 值越少 则 调用的优先级越高。
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 执行该方法
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 请求时 运行的方法
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        // 设置 请求的开始时间
        ctx.set("startTime",System.currentTimeMillis());

        return null;
    }
}
