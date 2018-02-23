package com.gta.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Desc: 注解方式实现 SpringAOP
 * User: jiangningning
 * Date: 2018/2/9
 * Time: 13:37
 */
@Aspect
@Component
@Order(2)
public class LogAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    public LogAspect() {
        System.out.println("######################################");
    }

    @Pointcut("execution(* com.gta.service..*.*(..))")
    public void log(){
    }

    @Before("log()")
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

    @After("log()")
    public void doAfter(){
        LOGGER.info("----------doAfter----------");
    }

    @AfterReturning(value = "log()", returning = "object")
    public void doAfterReturning(Object object){
        LOGGER.info("response={}", object);
    }

    @AfterThrowing(value = "log()", throwing = "e")
    public void doAfterThrowing(Exception e){
        LOGGER.info("方法抛出异常了===========" + e.toString());
    }

    //@Around("log()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        LOGGER.info("----------doAround----------");
        return pjp.proceed();
    }

}
