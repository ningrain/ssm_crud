package com.gta.aspect;

import com.gta.annotation.DataSourceAnnotation;
import com.gta.util.DynamicDataSourceHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Desc: 数据源切换切面
 * User: jiangningning
 * Date: 2018/2/24
 * Time: 11:09
 */
@Aspect
@Component
@Order(3)
public class DataSourceAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(DataSourceAspect.class);

    //切入点: 添加 @DataSourceAnnotation 注解的方法
    @Pointcut("@annotation(com.gta.annotation.DataSourceAnnotation)")
    public void switchDataSource(){}

    @Before("switchDataSource()")
    public void before(JoinPoint joinPoint){
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        String dataSource = ms.getMethod().getAnnotation(DataSourceAnnotation.class).value();
        DynamicDataSourceHolder.setDataSource(dataSource);
        LOGGER.info("------> 已经切换至数据源：" + dataSource);
    }

    // 执行完成后删除与当前线程绑定的数据源路由的key, 即还原默认数据源
    @After("switchDataSource()")
    public void after(){
        DynamicDataSourceHolder.clearDataSource();
    }

}
