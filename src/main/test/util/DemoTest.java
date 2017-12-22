package util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Desc:
 * User: jiangningning
 * Date: 2017/12/21
 * Time: 13:59
 */
@RunWith(JUnit4.class)
public class DemoTest{

    @Test
    public void demoTest1(){
        System.out.println("AAAAAAAAAAAA");
    }

    @Test
    public void demoTest2() {
        Map<String, Integer> correctAnswerMap = new HashMap<>();
        correctAnswerMap.put("1A", 3);
        correctAnswerMap.put("1B", 7);
        correctAnswerMap.put("1C", 9);
        correctAnswerMap.put("1D", 5);
        correctAnswerMap.put("1E", 1);
        correctAnswerMap.put("2A", 1);
        correctAnswerMap.put("2B", 3);
        correctAnswerMap.put("2C", 5);
        correctAnswerMap.put("2D", 7);
        correctAnswerMap.put("2E", 9);
        correctAnswerMap.put("3A", 9);
        correctAnswerMap.put("3B", 7);
        correctAnswerMap.put("3C", 5);
        correctAnswerMap.put("3D", 3);
        correctAnswerMap.put("3E", 1);

        String inputAnswerArray[] = {
                "1C", "2E", "3A"  // 9+9+9
        };
        List<String> inputAnswerList = Arrays.asList(inputAnswerArray);
        int countScore = 0;
        for (int i = 0; i < 3; i++) {
            countScore += correctAnswerMap.get(inputAnswerList.get(i));
        }
        System.out.println(countScore);
        if (rangeInDefined(countScore, 11, 24)){
            System.out.println("保守型");
        }
        if (rangeInDefined(countScore, 25, 36)){
            System.out.println("相对保守型");
        }
        if (rangeInDefined(countScore, 37, 72)){
            System.out.println("稳健型");
        }
        if (rangeInDefined(countScore, 73, 86)){
            System.out.println("相对积极型");
        }
        if (rangeInDefined(countScore, 87, 100)){
            System.out.println("积极型");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        System.out.println(sdf.format(new Date()));

    }

    private static boolean rangeInDefined(int current, int min, int max) {
        return Math.max(min, current) == Math.min(current, max);
    }

}
