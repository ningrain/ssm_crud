package com.gta.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/2/1
 * Time: 16:18
 */
public class Main {

    public static void main(String[] args) {
        //Person person = new Person();
        //person.setName("A");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext1.xml");
        Person person = (Person) ctx.getBean("person");
        person.hello();
        System.out.println(person.toString());

        Car car1 = (Car) ctx.getBean("car1");
        System.out.println(car1.toString());

        Car car2 = (Car) ctx.getBean("car2");
        System.out.println(car2.toString());

        Person person2 = (Person) ctx.getBean("person2");
        System.out.println(person2.toString());
    }

}
