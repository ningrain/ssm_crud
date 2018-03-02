package util;

import com.gta.BaseTest;
import com.gta.util.RedisUtil;
import com.gta.util.SpringContextUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Arrays;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/3/1
 * Time: 15:47
 */
public class RedisTest extends BaseTest{

    @Test
    public void test1(){
        //System.out.println(RedisUtil.exists("k1"));
        System.out.println(SpringContextUtil.getBeans());
    }

}
