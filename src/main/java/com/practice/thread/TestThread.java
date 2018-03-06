package com.practice.thread;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/3/5
 * Time: 17:16
 */
public class TestThread {

    public static void main(String[] args) {
        MyThread mt1 = new MyThread();
        MyThread mt2 = new MyThread();
        mt1.start();
        mt2.start();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " :" + i);
        }
    }

}


class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " :" + i);
        }
    }
}