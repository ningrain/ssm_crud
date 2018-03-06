package com.gta.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/3/5
 * Time: 9:50
 */
public class TimeHandler implements InvocationHandler {

    private Object object;

    public TimeHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("汽车开始行驶……");

        method.invoke(object);

        System.out.println("汽车结束行驶……");
        return null;
    }

    public static void main(String[] args) {
        Car car = new Car();
        InvocationHandler h = new TimeHandler(car);
        InvocationHandler h1 = new LogHandler(car);
        Class cls = car.getClass();
        Mover mover = (Mover) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), h);
        mover.move();
    }
}
