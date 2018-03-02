package com.practice.pattern;

import com.practice.pattern.singleton.HungrySingleton;
import com.practice.pattern.singleton.LazySingleton;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/2/27
 * Time: 9:40
 */
public class Main {

    public static void main(String[] args) {
        HungrySingleton s1 = HungrySingleton.getInstance();
        HungrySingleton s2 = HungrySingleton.getInstance();
        System.out.println(s1 == s2);

        LazySingleton s3 = LazySingleton.getInstance();
        LazySingleton s4 = LazySingleton.getInstance();
        System.out.println(s3 == s4);
    }

}
