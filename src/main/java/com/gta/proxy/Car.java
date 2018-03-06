package com.gta.proxy;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/3/5
 * Time: 9:51
 */
public class Car implements Mover{
    @Override
    public void move() {
        try {
            Thread.sleep(1000);
            System.out.println("汽车行驶中……");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
