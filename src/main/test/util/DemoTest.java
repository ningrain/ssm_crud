package util;

import com.gta.util.ReadExcelUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Supplier;

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
            /*String[] title = excelReader.readExcelTitle();
            System.out.println("获得Excel表格的标题:");
            for (String s : title) {
                System.out.print(s + " ");
            }*/

            // 对读取Excel表格内容测试
            Map<Integer, Map<Integer, Object>> map;
            excelReader.readExcelTitle();
            map = excelReader.readExcelContent();
            System.out.println("获得Excel表格的内容:");
            for (int i = 1; i <= map.size(); i++) {
                System.out.println(map.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
