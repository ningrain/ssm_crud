package com.gta.util;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * Desc: Ehcache工具类
 * User: jiangningning
 * Date: 2018/2/5
 * Time: 16:18
 */
public class EhCacheUtil {

    /* BASECACHE 值对应 ehcache.xml 文件中定义的 cache 名, 默认取出基础缓存（baseCache）*/
    private final static String BASECACHE = "baseCache";

    private final static CacheManager cacheManager;

    public static Cache cache;

    static {
        cacheManager = SpringContextUtil.getBean("cacheManager");
        cache = cacheManager.getCache(BASECACHE);
    }

    /** 私有化构造器 */
    private EhCacheUtil() {
    }

    /**
     * 获取缓存
     *
     * @param cacheName cacheName
     */
    public static Cache getCache(String cacheName){
        cache = cacheManager.getCache(cacheName);
        return cache;
    }

    /**
     * 缓存加入键值对
     *
     * @param cacheName cacheName
     * @param key       键
     * @param value     值
     */
    public static void put(String cacheName, String key, String value) {
        Cache cache = getCache(cacheName);
        if (null != cache) {
            Element e = new Element(key, value);
            cache.put(e);
        }
    }

    /**
     * 删除缓存
     *
     * @param cacheName cacheName
     * @param key       键
     */
    public static boolean remove(String cacheName, String key) {
        Cache cache = getCache(cacheName);
        return cache != null && cache.remove(key);
    }

    /**
     * 清楚所有缓存
     *
     * @param cacheName cacheName
     */
    public static void removeAll(String cacheName) {
        Cache cache = getCache(cacheName);
        if (null != cache) {
            cache.removeAll();
        }
    }

    public static Object get(String cacheName, String key) {
        Cache cache = getCache(cacheName);
        if (null != cache) {
            return cache.get(key).getObjectValue();
        }
        return null;
    }

}
