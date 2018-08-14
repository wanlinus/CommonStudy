package cn.wanlinus.proxy;

import java.lang.reflect.Proxy;

/**
 * @author wanli
 * @date 2018-08-09 16:59
 */
public class ExecutionClazz {
    public static void main(String[] args) {

        Calculator calculator = new CalculatorImpl();
        DynamicProxyCal dynamicProxyCal = new DynamicProxyCal(calculator);
        Calculator proxy = (Calculator) Proxy.newProxyInstance(calculator.getClass().getClassLoader(),
                calculator.getClass().getInterfaces(), dynamicProxyCal);
        proxy.del(5, 6);

    }
}
