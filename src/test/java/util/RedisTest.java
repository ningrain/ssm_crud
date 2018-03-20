package util;

import com.gta.BaseTest;
import com.gta.util.RedisUtil;
import com.gta.util.SpringContextUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/3/1
 * Time: 15:47
 */
public class RedisTest extends BaseTest {

    @Test
    public void test1(){
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        System.out.println(SpringContextUtil.getBeans());
        RedisUtil redisUtil = SpringContextUtil.getBean("redisUtil");
        RedisUtil redisUtil2 = SpringContextUtil.getBean("redisUtil");
        System.out.println(redisUtil == redisUtil2);
        //System.out.println(RedisUtil.exists("k1"));
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
    }
}
