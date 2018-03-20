package com.practice.pattern.factory;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/3/15
 * Time: 17:15
 */
public class ShapeFactory {

    public Shape getShape(String shapeType){
        Shape shape = null;
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            shape = new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            shape = new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            shape = new Rectangle();
        }
        return shape;

    }

}
