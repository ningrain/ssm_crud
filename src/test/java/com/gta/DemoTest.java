package java.com.gta;

import com.gta.util.EhCacheUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Random;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/2/5
 * Time: 14:58
 */
@RunWith(JUnit4.class)
public class DemoTest {

    /**
     * 身份证
     */
    private static final String idcard = "^[1-9]([0-9]{14}|[0-9]{17})$";


    @Test
    public void test1() {
        System.out.println("34222419920906061X".matches(idcard));
    }

    @Test
    public void test2() {
        System.out.println("34222419920906061X".matches(idcard));
    }

    @Test
    public void test3() {
        EhCacheUtil.put("baseCache", "AAA", "aaaaaaaaaa");
        System.out.println(EhCacheUtil.get("baseCache", "AAA"));
        System.out.println(EhCacheUtil.cache);
        EhCacheUtil.getCache("menuCache");
        System.out.println(EhCacheUtil.cache);
    }

    @Test
    public void test4() {
        /*LOGGER.debug("This is a debug level log.");
        LOGGER.info("This is a info level log.");
        LOGGER.fatal("This is a fatal level log.");
        LOGGER.error("This is an error level log.")*/;
    }

    @Test
    public void test5(){
        //test5(); // 递归调用, java.lang.StackOverflowError

        /* java.lang.OutOfMemoryError: Java heap space
        *  VM options: -Xms6m -Xmx6m -XX:+PrintGCDetails
        * */
        String str = "aaaaaaaaaaaa";
        while (true) {
            str += str + new Random().nextInt(8888888) + new Random().nextInt(999999999);
        }

    }

    @Test
    public void test6(){
        System.out.println(111);
    }

}
