package util;

import java.util.function.Supplier;

/**
 * Desc:
 * User: jiangningning
 * Date: 2017/12/29
 * Time: 16:44
 */
public class Car {

    private String name = "Bens";

    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another);
    }

    public void repair() {
        System.out.println("Repairing " + this.toString());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
