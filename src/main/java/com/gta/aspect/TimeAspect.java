package com.gta.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.GregorianCalendar;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/2/1
 * Time: 9:20
 */
//@Aspect
@Component
@Order(1)
public class TimeAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(TimeAspect.class);

    @Pointcut("execution(public * com.gta.service..*.*(..))")
    public void time(){}

    @Before("time()")
    public void doBefore(){
        LOGGER.info("before: " + new GregorianCalendar().getTimeInMillis());
    }

    @After("time()")
    public void doAfter(){
        LOGGER.info("after: " + new GregorianCalendar().getTimeInMillis());
    }

}
