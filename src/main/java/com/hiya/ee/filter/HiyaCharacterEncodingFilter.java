package com.hiya.ee.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HiyaCharacterEncodingFilter implements Filter
{
    private FilterConfig config;

    public void destroy()
    {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {
        String encoding = config.getInitParameter("encoding");
        if (null != encoding && !"".equals(encoding))
        {
            request.setCharacterEncoding(encoding);
        }
        chain.doFilter(request, response);
        // 将修改过的请求和响应传递给下一个过滤器或者Servlet
    }

    // Filter初始化时的回调方法
    // FilterConfig接口实例中封装了这个Filter的初始化参数
    public void init(FilterConfig config)
    {
        this.config = config;
    }
}