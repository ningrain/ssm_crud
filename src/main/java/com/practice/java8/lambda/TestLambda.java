package com.practice.java8.lambda;

import com.practice.java8.functionalInterface.MyFunction1;
import com.practice.java8.functionalInterface.NumOperator;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/2/27
 * Time: 13:40
 */
public class TestLambda {

    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        test5();
    }

    /**
     *  语法格式一： 无参数，无返回值
     *        eg : () -> System.out.println("...");
     */
    public static void test1(){
        int i = 0; // 省略默认的 final 修饰符
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!" + i);
            }
        };
        r1.run();

        System.out.println("============================");

        Runnable r2 = () -> System.out.println("Hello Lambda!" + i);
        r2.run();
    }

    /**
     *  语法格式二： 一个参数，无返回值
     *        eg : (x) -> System.out.println(x); 或  x -> System.out.println(x);
     */
    public static void test2(){
        System.out.println("============================");
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("Hello World!");
    }

    /**
     *  语法格式三： 两个或者多个参数，有返回值， lambda体中有多条语句
     *        eg : Comparator<Integer> com = (x, y) -> {
     *                  System.out.println("函数式接口");
     *                  return Integer.compare(x, y);
     *             };
     */
    public static void test3(){
        System.out.println("============================");
        Comparator<Integer> com = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
        System.out.println(com.compare(3, 5));
    }

    /**
     *  语法格式三： 两个或者多个参数，有返回值， lambda体中有一条语句， return 和 大括号都可以省略
     *        eg : Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
     *        Lambda 表达式的参数列表的数据类型可以省略不写，因为 JVM 可以通过上下文推断出来，即“类型推断”
     *        即       Comparator<Integer> com = (Integer x, Integer y) -> Integer.compare(x, y);
     *        可以写成 Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
     */
    public static void test4(){
        System.out.println("============================");
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        System.out.println(com.compare(3, 5));
    }

    public static void test5(){
        System.out.println(getNum(100, (x) -> x * x));
        System.out.println(numToString(100, (x) -> String.valueOf(x)));
    }

    public static Integer getNum(Integer in, NumOperator operator){
        return operator.getValue(in);
    }

    public static String numToString(Integer in, MyFunction1<Integer, String> myFun){
        return myFun.getValue(in);
    }

}
