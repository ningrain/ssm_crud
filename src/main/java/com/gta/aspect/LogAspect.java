package com.gta.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Desc: xml 配置方式实现 SpringAOP
 * User: jiangningning
 * Date: 2018/2/9
 * Time: 13:37
 */
public class LogAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    public LogAspect() {
        System.out.println("######################################");
    }

    public void log(){
    }

    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        LOGGER.info("----------doBefore----------");
        /*//url
        LOGGER.info("url --> {}", request.getRequestURL());
        //method
        LOGGER.info("method={}", request.getMethod());
        //ip
        LOGGER.info("ip={}", request.getRemoteAddr());
        //类方法
        LOGGER.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "()");
        //参数
        LOGGER.info("args={}", joinPoint.getArgs());*/

    }

    public void doAfter(){
        LOGGER.info("----------doAfter----------");
    }

    public void doAfterReturning(Object object){
        LOGGER.info("----------doAfterReturning----------");
        LOGGER.info("response={}", object);
    }

    public void doAfterThrowing(Exception e){
        LOGGER.info("----------doAfterThrowing----------");
        LOGGER.info("方法抛出异常了===========" + e.toString());
    }

    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        LOGGER.info("----------doAround----------");
        return pjp.proceed();
    }

}
