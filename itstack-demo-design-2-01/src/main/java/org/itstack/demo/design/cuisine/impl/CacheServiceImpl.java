package org.itstack.demo.design.cuisine.impl;

import org.itstack.demo.design.RedisUtils;
import org.itstack.demo.design.matter.EGM;
import org.itstack.demo.design.matter.IIR;
import org.itstack.demo.design.CacheService;

import java.util.concurrent.TimeUnit;

/**
 * 在缓存服务中引入RedisUtils、EGM、IIR
 * 通过增加传入redisType来区分使用哪一种缓存
 */
public class CacheServiceImpl implements CacheService {

    private final RedisUtils redisUtils = new RedisUtils();

    private final EGM egm = new EGM();

    private final IIR iir = new IIR();

    public String get(String key, int redisType) {

        if (1 == redisType) {
            return egm.gain(key);
        }

        if (2 == redisType) {
            return iir.get(key);
        }

        return redisUtils.get(key);
    }

    public void set(String key, String value, int redisType) {

        if (1 == redisType) {
            egm.set(key, value);
            return;
        }

        if (2 == redisType) {
            iir.set(key, value);
            return;
        }

        redisUtils.set(key, value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit, int redisType) {

        if (1 == redisType) {
            egm.setEx(key, value, timeout, timeUnit);
            return;
        }

        if (2 == redisType) {
            iir.setExpire(key, value, timeout, timeUnit);
            return;
        }

        redisUtils.set(key, value, timeout, timeUnit);
    }

    public void del(String key, int redisType) {

        if (1 == redisType) {
            egm.delete(key);
            return;
        }

        if (2 == redisType) {
            iir.del(key);
            return;
        }

        redisUtils.del(key);
    }


}
