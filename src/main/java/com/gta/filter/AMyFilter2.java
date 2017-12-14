package com.gta.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Desc: AMyFilter2
 * User: jiangningning
 * Date: 2017/12/13
 * Time: 15:34
 */
@WebFilter(filterName = "aMyFilter2", urlPatterns = "/*")
public class AMyFilter2 implements Filter {

    private static Logger logger = Logger.getLogger(AMyFilter2.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String project = filterConfig.getInitParameter("project");
        logger.info("AMyFilter2 init方法……");
        logger.info("初始化参数值：project=" + project);
    }

    @Override
    public void doFilter(ServletRequest requestequest, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("AMyFilter2 doFilter方法……");
        chain.doFilter(requestequest, response);
    }
}
