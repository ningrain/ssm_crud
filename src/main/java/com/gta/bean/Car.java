package com.gta.bean;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/2/1
 * Time: 16:24
 */
public class Car {

    private String name;
    private String address;
    private double price;
    private int maxSpeed;

    public Car() {
    }

    public Car(String name, String address, double price) {
        this.name = name;
        this.address = address;
        this.price = price;
    }

    public Car(String name, String address, double price, int maxSpeed) {
        this.name = name;
        this.address = address;
        this.price = price;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
