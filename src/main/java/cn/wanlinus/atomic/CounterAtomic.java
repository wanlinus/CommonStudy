package cn.wanlinus.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wanli
 * @date 2018-08-09 16:22
 */
public class CounterAtomic {
    private AtomicInteger counter = new AtomicInteger();

    public AtomicInteger getCounter() {
        return counter;
    }

    public void setCounter(AtomicInteger counter) {
        this.counter = counter;
    }

    public int increase() {
        return counter.incrementAndGet();
    }

    public int decrease() {
        return counter.decrementAndGet();
    }

}
