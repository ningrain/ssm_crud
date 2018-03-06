package com.gta.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/3/5
 * Time: 10:05
 */
public class LogHandler implements InvocationHandler{

    private Object object;

    public LogHandler(Object object) {
        this.object = object;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("日志开始……");
        method.invoke(object);
        System.out.println("日志结束……");
        return null;
    }
}
