package cn.wanlinus.proxy;

/**
 * @author wanli
 * @date 2018-08-09 16:57
 */
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int del(int a, int b) {
        return a - b;
    }
}
