package com.practice.pattern;

import com.practice.pattern.singleton.HungrySingleton;
import com.practice.pattern.singleton.LazySingleton;

import javax.sound.midi.Soundbank;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/2/27
 * Time: 9:40
 */
public class Main {

    public static void main(String[] args) {
        /*HungrySingleton s1 = HungrySingleton.getInstance();
        HungrySingleton s2 = HungrySingleton.getInstance();
        System.out.println(s1 == s2);

        LazySingleton s3 = LazySingleton.getInstance();
        LazySingleton s4 = LazySingleton.getInstance();
        System.out.println(s3 == s4);*/


        float f = 3.14159262134141f;
        double d = 3.14159262134141d;
        System.out.println(f);
        System.out.println(d);
        int i =5;
        byte b = (byte)i;
        System.out.println(b);
        System.out.println(i++);
        System.out.println(++i);
        Map<String, String> map = new HashMap<>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key="+ entry.getKey() + " value="+entry.getValue());
        }
    }

}
