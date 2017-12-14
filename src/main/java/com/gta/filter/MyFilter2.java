package com.gta.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Desc: MyFilter2
 * User: jiangningning
 * Date: 2017/12/13
 * Time: 15:34
 * AMyFilter2 先执行， MyFilter2 后执行 因为字母 A 在 M 之前
 */
@WebFilter(filterName = "myFilter2", urlPatterns = "/*")
public class MyFilter2 implements Filter {

    private static Logger logger = Logger.getLogger(MyFilter2.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String project = filterConfig.getInitParameter("project");
        logger.info("MyFilter2 init方法……");
        logger.info("初始化参数值：project=" + project);
    }

    @Override
    public void doFilter(ServletRequest requestequest, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("MyFilter2 doFilter方法……");
        chain.doFilter(requestequest, response);
    }
}
