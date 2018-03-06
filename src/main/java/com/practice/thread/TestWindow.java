package com.practice.thread;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/3/6
 * Time: 9:13
 */

class Window extends Thread{

    private static int tickets = 100;

    public Window(String name) {
        super(name);
    }

    private static final Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (tickets > 0) {
                    try {
                        Thread.currentThread().sleep(10);
                        System.out.println(Thread.currentThread().getName() + "售票： 票号" + tickets--);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }
    }
}

public class TestWindow {

    public static void main(String[] args) throws InterruptedException {
        Window w1 = new Window("窗口1");
        Window w2 = new Window("窗口2");
        Window w3 = new Window("窗口3");
        //w3.sleep(1000);
        w2.start();
        w3.start();
        w1.start();
    }
}
