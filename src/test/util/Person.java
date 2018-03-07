package util;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/3/2
 * Time: 11:14
 */
public class Person {

    private String pet;

    public void feedPet(Animal animal){
        System.out.println("我喂了：" + animal.getName());
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }
}
