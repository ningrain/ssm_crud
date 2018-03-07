package com.gta.bean;

import java.lang.reflect.Method;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/1/15
 * Time: 8:50
 */
@SuppressWarnings("unchecked")
public class Biology {

    private int age;

    public void eat() {
        System.out.println("所有生物都有吃东西的能力");
    }

    public static void main(String[] args) throws Exception {
        //Biology b = new Dog();
        //b.eat();
        Class c = Dog.class;
        Dog dog = (Dog) c.newInstance();
        Method m = c.getMethod("eat");
        m.invoke(dog);
        System.out.println("+++++++++++++++++++++++");
        Class c1 = Class.forName("com.gta.bean.Dog");
        System.out.println(c == c1);
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        System.out.println(dog1 == dog2);
    }

}

class Animal extends Biology {
    @Override
    public void eat() {
        System.out.println("动物具有吃的能力");
    }
}

class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("狗狗喜欢吃肉");
    }
}
