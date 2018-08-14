package cn.wanlinus.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wanli
 * @date 2018-08-09 16:59
 */
public class DynamicProxyCal implements InvocationHandler {
    Object obj;

    public DynamicProxyCal(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object o = method.invoke(obj, args);
        System.out.println(o);
        System.out.println("after");
        return o;
    }
}
