package com.gta.util;

import org.apache.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/3/1
 * Time: 15:26
 */
public class RedisUtil {

    private static Logger logger = Logger.getLogger(RedisUtil.class);

    private static RedisTemplate<Serializable, Object> redisTemplate;

    /**
     * 写入或更新缓存
     *
     * @param key   键
     * @param value 值
     * @return boolean
     */
    public static boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate
                    .opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            logger.error("write redis is fail");
            e.printStackTrace();

        }
        return result;
    }

    /**
     * 写入缓存
     * 设置失效时间
     *
     * @param key        键
     * @param value      值
     * @param expireTime 失效时间
     * @return boolean
     */
    public static boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate
                    .opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 读取缓存
     *
     * @param key 键
     * @return Object 值
     */
    public static Object get(final String key) {
        Object result;
        ValueOperations<Serializable, Object> operations = redisTemplate
                .opsForValue();
        result = operations.get(key);
        return result;
    }

    /**
     * 删除对应的value
     *
     * @param key 键
     */
    private static void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 批量删除对应的value
     *
     * @param keys 批量key
     */
    public static void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     *
     * @param pattern 正则表达式
     */
    public static void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key 键
     * @return boolean
     */
    public static boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    public void setRedisTemplate(RedisTemplate<Serializable, Object> redisTemplate) {
        RedisUtil.redisTemplate = redisTemplate;
    }
}
