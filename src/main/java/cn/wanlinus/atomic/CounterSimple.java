package cn.wanlinus.atomic;

/**
 * @author wanli
 * @date 2018-08-09 16:20
 */
public class CounterSimple {
    private int counter = 0;

    public int increase() {
        synchronized (this) {
            counter = counter + 1;
            return counter;
        }
    }

    public int decrease() {
        synchronized (this) {
            counter = counter - 1;
            return counter;
        }
    }
}
