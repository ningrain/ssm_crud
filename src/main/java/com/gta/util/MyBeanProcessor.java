package com.gta.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/3/9
 * Time: 16:06
 */
// 可以配置bean的前置（postProcessBeforeInitialization）和后置（postProcessAfterInitialization）通知
public class MyBeanProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {
        System.out.println("postProcessBeforeInitialization……");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {
        System.out.println("postProcessAfterInitialization……");
        return bean;
    }
}
