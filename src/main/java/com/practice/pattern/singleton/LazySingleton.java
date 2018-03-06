package com.practice.pattern.singleton;

/**
 * Desc: 单例-懒汉模式(双校验同步锁，线程安全)
 * User: jiangningning
 * Date: 2018/2/27
 * Time: 9:28
 */
public class LazySingleton {

    private LazySingleton() {
    }

    //只声明，不实例化，用到该类对象的时候才实例化，线程不安全
    private static LazySingleton instance = null;

    public static LazySingleton getInstance() {
        if (instance == null) { //若已经实例化对象，后面进入的线程不会进入到同步代码块中，效率高一些
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

}
