package org.itstack.demo.desgin.factory;

import java.util.concurrent.TimeUnit;

/**
 * 定义接口，统一EGM和IIR方法，
 * 方法与CacheService一致，便于把 EGM和IIR 代理为CacheService对象
 */
public interface ICacheAdapter {

    String get(String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);

}
