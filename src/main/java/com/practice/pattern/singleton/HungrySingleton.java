package com.practice.pattern.singleton;

/**
 * Desc: 单例-饿汉模式
 * User: jiangningning
 * Date: 2018/2/27
 * Time: 9:32
 */
public class HungrySingleton {

    private HungrySingleton(){}

    // 类加载的时候就进行初始化，线程安全
    private static HungrySingleton instance = new HungrySingleton();

    public static HungrySingleton getInstance(){
        return instance;
    }

}
