package org.itstack.demo.design;

import java.util.concurrent.TimeUnit;

/**
 * 抽象缓存接口，定义方法 单机使用
 */
public interface CacheService {

    String get(final String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);

}
