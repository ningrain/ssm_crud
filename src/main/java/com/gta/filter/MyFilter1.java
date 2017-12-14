package com.gta.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;

/**
 * Desc: MyFilter1
 * User: jiangningning
 * Date: 2017/12/13
 * Time: 15:34
 */
public class MyFilter1 implements Filter {

    private static Logger logger = Logger.getLogger(MyFilter1.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String project = filterConfig.getInitParameter("project");
        logger.info("MyFilter1 init方法……");
        logger.info("初始化参数值：project=" + project);
    }

    @Override
    public void doFilter(ServletRequest requestequest, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("MyFilter1 doFilter方法……");
        chain.doFilter(requestequest, response);
    }
}
