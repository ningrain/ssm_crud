package com.gta.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Desc: 可以在任何代码任何地方任何时候取出ApplicaitonContext.
 * User: jiangningning
 * Date: 2017/12/5
 * Time: 10:49
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    /*私有化构造器*/
    private SpringContextUtil() {
        super();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public ApplicationContext getApplicationContext(ApplicationContext applicationContext) {
        return applicationContext;
    }

    /**
     * 根据名称获取bean
     *
     * @param name beanName
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        checkApplicationContext();
        return (T) context.getBean(name);
    }

    /**
     * 根据类型获取bean
     *
     * @param clazz beanType
     */
    public static <T> T getBean(Class<T> clazz) {
        checkApplicationContext();
        return context.getBean(clazz);
    }

    /**
     * 根据名称获取指定类型的bean
     *
     * @param name  beanName
     * @param clazz beanType
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return context.getBean(name, clazz);
    }

    /**
     * 判断context中是否包含名称为name的bean
     *
     * @param name beanName
     */
    public static boolean containsBean(String name) {
        return context.containsBean(name);
    }

    /**
     * 是否是单例
     *
     * @param name beanName
     */
    public static boolean isSingleton(String name) {
        return context.isSingleton(name);
    }

    /**
     * 是否是单例
     *
     * @param name beanName
     */
    public static Class getType(String name) {
        return context.getType(name);
    }

    private static void checkApplicationContext() {
        if (context == null)
            throw new IllegalStateException("applicaitonContext未注入,请在applicationContext.xml中定义bean：SpringContextUtil");
    }

}
