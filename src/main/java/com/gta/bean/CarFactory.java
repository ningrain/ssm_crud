package com.gta.bean;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/3/9
 * Time: 16:28
 */
public class CarFactory {

    private CarFactory(){}

    private static Car car = new Car();

    public Car getInstance(){
        if (car == null) {
            car = new Car();
        }
        return car;
    }


}
