package java.util;

import com.gta.bean.Course;
import com.gta.util.ReadExcelUtils;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Desc:
 * User: jiangningning
 * Date: 2017/12/21
 * Time: 13:59
 */
@RunWith(JUnit4.class)
public class DemoTest {

    @Test
    public void demoTest1() {
        System.out.println("AAAAAAAAAAAA");
    }

    @Test
    public void demoTest2() {
        Map<String, Integer> correctAnswerMap = new HashMap<>();
        correctAnswerMap.put("1A", 3);
        correctAnswerMap.put("1B", 7);
        correctAnswerMap.put("1C", 9);
        correctAnswerMap.put("1D", 5);
        correctAnswerMap.put("1E", 1);
        correctAnswerMap.put("2A", 1);
        correctAnswerMap.put("2B", 3);
        correctAnswerMap.put("2C", 5);
        correctAnswerMap.put("2D", 7);
        correctAnswerMap.put("2E", 9);
        correctAnswerMap.put("3A", 9);
        correctAnswerMap.put("3B", 7);
        correctAnswerMap.put("3C", 5);
        correctAnswerMap.put("3D", 3);
        correctAnswerMap.put("3E", 1);

        String inputAnswerArray[] = {
                "1C", "2E", "3A"  // 9+9+9
        };
        List<String> inputAnswerList = Arrays.asList(inputAnswerArray);
        int countScore = 0;
        for (int i = 0; i < 3; i++) {
            countScore += correctAnswerMap.get(inputAnswerList.get(i));
        }
        System.out.println(countScore);
        if (rangeInDefined(countScore, 11, 24)) {
            System.out.println("保守型");
        }
        if (rangeInDefined(countScore, 25, 36)) {
            System.out.println("相对保守型");
        }
        if (rangeInDefined(countScore, 37, 72)) {
            System.out.println("稳健型");
        }
        if (rangeInDefined(countScore, 73, 86)) {
            System.out.println("相对积极型");
        }
        if (rangeInDefined(countScore, 87, 100)) {
            System.out.println("积极型");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        System.out.println(sdf.format(new Date()));

    }

    @Test
    public void demoTest3() {
        final String separator = ",";
        Arrays.asList("b", "c", "a").sort(String::compareTo);
    }

    private static boolean rangeInDefined(int current, int min, int max) {
        return Math.max(min, current) == Math.min(current, max);
    }


    @Test
    public void demoTest4() {
        MathOperation addition = (int a, int b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation multiplication = (a, b) -> {
            return a * b;
        };
        MathOperation division = (a, b) -> a / b;
        System.out.println(operate(5, 10, addition));
        System.out.println(operate(5, 10, subtraction));
        System.out.println(operate(5, 10, multiplication));
        System.out.println(operate(10, 5, division));

        GreetingService greetingService1 = message -> System.out.println("Hello " + message);
        GreetingService greetingService2 = (message) -> System.out.println("Hello " + message);

        greetingService1.sayMessage("Runoob");
        greetingService2.sayMessage("Google");
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }


    @Test
    public void demoTest5() {
        //语法是Class::new
        Car car = Car.create(Car::new);
        System.out.println(car.getName());
        final List<Car> cars = Arrays.asList(car);
        //语法是Class::static_method
        cars.forEach(Car::collide);
        //语法是Class::method
        cars.forEach(Car::repair);
        cars.forEach(System.out::println);
    }

    @Test
    public void demoTest6() {
        /*out:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 1 && j == 2)
                    break out;
                System.out.println("i=" + i + ", j=" + j);
            }
        }*/

        //* Month value is 0-based. e.g., 0 for January.
        Calendar calendar = new GregorianCalendar(2012, 1, 29);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(calendar.getTime()));
        calendar.add(Calendar.YEAR, 1);
        System.out.println(sdf.format(calendar.getTime()));
    }

    @Test
    public void demoTest7() {
        try {
            String filePath = "E:\\test.xlsx";
            ReadExcelUtils excelReader = new ReadExcelUtils(filePath);
            // 对读取Excel表格标题测试
            String[] title = excelReader.readExcelTitle();
            System.out.println("获得Excel表格的标题:");
            for (String s : title) {
                System.out.print(s + " ");
            }
            System.out.println();
            // 对读取Excel表格内容测试
            Map<Integer, Map<Integer, Object>> map = excelReader.readExcelContent();
            System.out.println("获得Excel表格的内容:");
            for (int i = 1; i <= map.size(); i++) {
                System.out.println(map.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void demoTest8() {
        Course c1 = new Course("1", "语文");
        Course c2 = new Course("2", "语文");
        //System.out.println(c1.equals(c2));
        byte[] bytes = String.valueOf(8143).getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(Integer.toHexString(bytes[i]));
        }
    }

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Test
    public void demoTest9(){
        //DateTime dateTime = new DateTime();
        //System.out.println(dateTime.toString("yyyy-MM-dd HH:mm:ss"));

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.MILLISECONDS.sleep(2000);
                    System.out.println(sdf.format(new Date("2010/10/10 15:23:23")));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        /*Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(sdf.format(new Date("2018/10/10 15:23:23")));
            }
        });*/
        //thread1.start();
        //thread2.start();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(thread1);
        //executorService.execute(thread2);
        executorService.shutdown();
    }


    public static  String formatDate(Date date)throws Exception{
        return sdf.format(date);
    }

    public static Date parse(String strDate) throws Exception{

        return sdf.parse(strDate);
    }

    public static DateTime dateTime = new DateTime();
    public static void main(String[] args) {
        System.out.println(dateTime);
        for(int i = 0; i < 3; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.MILLISECONDS.sleep(2000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        System.out.println(dateTime.toString("yyyy-MM-dd HH:mm:ss"));
                        //System.out.println(DemoTest.parse("2013-05-24 06:02:20"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public static void alterableMathod(Animal... animals ){
        for (Animal animal : animals) {
            System.out.println(animal.getLegNum());
        }
    }

    @Test
    public void demoTest10(){
        Person p = new Person();
        Animal dog = new Dog();
        dog.setName("大黄");
        dog.setLegNum(4);
        Animal fish = new Fish();
        fish.setLegNum(0);
        p.feedPet(dog);
        alterableMathod(dog, fish);
        final int a;
        a = 20;
    }

    @Test
    public void test11(){
        Comparator<Student> comparator = Comparator.comparing(Student::getName).thenComparingInt(Student::getAge);
        TreeSet<Student> students = new TreeSet<>(comparator);
        Student stu1 = new Student("AA", 21);
        Student stu2 = new Student("BB", 24);
        Student stu3 = new Student("CC", 23);
        Student stu4 = new Student("CC", 22);
        students.add(stu1);
        students.add(stu2);
        students.add(stu3);
        students.add(stu4);
        for (Student stu : students){
            System.out.println(stu);
        }

    }


    class Student {
        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Student student = (Student) o;

            if (name != null ? !name.equals(student.name) : student.name != null) return false;
            return age != null ? age.equals(student.age) : student.age == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (age != null ? age.hashCode() : 0);
            return result;
        }

        //@Override
        public int compareTo(Object o) {
            if (o instanceof Student) {
                Student student = (Student) o;
                int result = this.name.compareTo(student.getName());
                if (result == 0){
                    return this.age.compareTo(student.getAge());
                } else {
                    return result;
                }
            }
            return 0;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    class Mythread extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }

    @Test
    public void test12(){

        Mythread mt = new Mythread();
        mt.start();

        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}
