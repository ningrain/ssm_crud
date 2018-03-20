package util;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/3/2
 * Time: 11:14
 */
public class Person {

    private String pet;

    private int age;

    public void feedPet(Animal animal){
        System.out.println("我喂了：" + animal.getName());
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return pet != null ? pet.equals(person.pet) : person.pet == null;
    }

    /*@Override
    public int hashCode() {
        return pet != null ? pet.hashCode() : 0;
    }*/

    @Override
    public int hashCode() {
        int result = pet != null ? pet.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}
