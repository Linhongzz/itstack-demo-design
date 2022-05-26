package org.itstack.demo.desgin.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JDKProxy {

    /**
     * 获取代理类
     *
     * @param interfaceClass 需要被代理成什么对象
     * @param cacheAdapter   被代理的对象
     * @return 代理对象
     */
    public static <T> T getProxy(Class<T> interfaceClass, ICacheAdapter cacheAdapter) throws Exception {
        InvocationHandler handler = new JDKInvocationHandler(cacheAdapter);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?>[] classes = interfaceClass.getInterfaces();
        // TODO: 2022/5/25 查看源码
        return (T) Proxy.newProxyInstance(classLoader, new Class[]{classes[0]}, handler);// 获取动态代理对象
    }

}
