package org.itstack.demo.desgin.factory;

import org.itstack.demo.desgin.util.ClassLoaderUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKInvocationHandler implements InvocationHandler {

    /**
     * 被代理的对象
     */
    private final ICacheAdapter cacheAdapter;

    public JDKInvocationHandler(ICacheAdapter cacheAdapter) {
        this.cacheAdapter = cacheAdapter;
    }

    /**
     * 在触发方法的时候可以对方法进行增强
     *
     * @param proxy  代理对象？
     * @param method 方法
     * @param args   参数
     * @return 返回结果
     * @throws Throwable 异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 将ICacheAdapter方法 代理为 CacheServiceImpl方法
        return ICacheAdapter.class
                .getMethod(method.getName(), ClassLoaderUtils.getClazzByArgs(args))
                .invoke(cacheAdapter, args);

        // 以下写法为增强原有方法写法
//        System.out.println("调用方法前");
//        Object invoke = method.invoke(cacheAdapter, args);
//        System.out.println("调用方法后");
    }

}
