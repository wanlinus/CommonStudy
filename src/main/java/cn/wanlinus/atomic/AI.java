package cn.wanlinus.atomic;

/**
 * AtomicInteger
 *
 * result:
 * *******************
 * AtomicInteger: 1413
 * Simple: 4528
 * ********************
 *
 * @author wanli
 * @date 2018-08-09 16:18
 */
public class AI {
    public static void main(String[] args) {
        int count = 100000000;
        long startTime1 = System.currentTimeMillis();
        CounterAtomic counterAtomic = new CounterAtomic();
        for (int i = 0; i < count; i++) {
            counterAtomic.increase();
        }
        for (int i = 0; i < count; i++) {
            counterAtomic.decrease();
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("AtomicInteger: " + (endTime1 - startTime1));
        long startTime2 = System.currentTimeMillis();
        CounterSimple counterSimple = new CounterSimple();
        for (int i = 0; i < count; i++) {
            counterSimple.increase();
        }
        for (int i = 0; i < count; i++) {
            counterSimple.decrease();
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("Simple: " + (endTime2 - startTime2));

    }
}
