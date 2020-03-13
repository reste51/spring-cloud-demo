package com.imooc.add.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 请求后 记录日志的 过滤器
 * @ClassName AccessLogFilter
 * @Description TODO
 * @Author 50204
 * @Date 2020/3/11 8:19
 * @Version 1.0
 **/
@Slf4j
@Component
public class AccessLogFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    /**
     * 执行顺序, 最后执行, 记录请求的耗时时间
     * @return
     */
    @Override
    public int filterOrder() {
        // 发送 响应的过滤器 再 晚一个
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 获取 请求上下文
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        //获取 前置过滤器设置的 开始时间
        Long startTime = (Long) ctx.get("startTime");
        // 获取 请求的路径
        String uri = request.getRequestURI();

        //请求的 间隔
        long duration = System.currentTimeMillis() - startTime;

        // 日志输出
        log.info("uri: " + uri + ", duration: " + (duration/100) +  " ms");

        return null;
    }
}
