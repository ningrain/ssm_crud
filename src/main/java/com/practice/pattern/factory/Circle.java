package com.practice.pattern.factory;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/3/15
 * Time: 17:12
 */
public class Circle implements Shape {
    @Override
    public void draw(String shapeType) {
        System.out.println("draw a circle……");
    }
}
