package com.gta.bean;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/2/1
 * Time: 16:17
 */
public class Person {

    private String name;

    private Car car;

    public void setName(String name) {
        System.out.println("Person's set name: " + name);
        this.name = name;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void hello(){
        System.out.println("hello: " + name);
    }

    public Person() {
        System.out.println("Constructor……");
    }

    public Person(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", car=" + car +
                '}';
    }
}
