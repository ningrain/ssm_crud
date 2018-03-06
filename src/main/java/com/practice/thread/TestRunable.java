package com.practice.thread;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/3/6
 * Time: 9:25
 */
public class TestRunable implements Runnable{

    private int ticket = 100;

    @Override
    public void run() {
        while (true){
            synchronized (this) {
                if (ticket > 0){
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "售票： 票号" + ticket--);
                }else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new TestRunable();
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t2.start();
        t1.start();
    }
}
