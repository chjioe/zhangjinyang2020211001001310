package com.zhangjinyang.Lab2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "ZhangJinYangFilter")
public class ZhangJinYangFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("ZhangJinYangFilter-->before chain");
        chain.doFilter(request, response);
        System.out.println("ZhangJinYangFilter-->after chain");
    }
}
