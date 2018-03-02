package com.practice.pattern.singleton;

/**
 * Desc: 单例-懒汉模式
 * User: jiangningning
 * Date: 2018/2/27
 * Time: 9:28
 */
public class LazySingleton {

    private LazySingleton(){}

    //只声明，不实例化，用到该类对象的时候才实例化，线程不安全
    private static LazySingleton instance;

    public static LazySingleton getInstance(){
        if (instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }

}
