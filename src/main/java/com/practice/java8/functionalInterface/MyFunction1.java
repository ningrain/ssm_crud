package com.practice.java8.functionalInterface;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/2/27
 * Time: 14:48
 */
@FunctionalInterface
public interface MyFunction1<T, R> {

    R getValue(T t);

}
