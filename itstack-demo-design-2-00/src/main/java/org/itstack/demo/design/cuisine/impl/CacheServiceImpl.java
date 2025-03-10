package org.itstack.demo.design.cuisine.impl;

import org.itstack.demo.design.CacheService;
import org.itstack.demo.design.RedisUtils;

import java.util.concurrent.TimeUnit;

/**
 * 实现缓存服务，单机使用
 */
public class CacheServiceImpl implements CacheService {

    private final RedisUtils redisUtils = new RedisUtils();

    public String get(String key) {
        return redisUtils.get(key);
    }

    public void set(String key, String value) {
        redisUtils.set(key, value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        redisUtils.set(key, value, timeout, timeUnit);
    }

    public void del(String key) {
        redisUtils.del(key);
    }

}
