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
        System.out.println("Car's constructor……");
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

    public void setName(String name) {
        System.out.println("Car's set method……" + name);
        this.name = name;
    }

    public void init(){
        System.out.println("Car's init method……");
    }

    public void destroy(){
        System.out.println("Car's destroy method……");
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
