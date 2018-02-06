package com.gta;

import com.gta.util.EhCacheUtil;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.InputStream;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/2/5
 * Time: 14:58
 */
//@RunWith(JUnit4.class)
public class DemoTest extends BaseTest{

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

}
