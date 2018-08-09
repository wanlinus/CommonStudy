package cn.wanlinus.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author wanli
 * @date 2018-08-09 15:35
 */
public class ThreadNotPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        int count = Num.num200k;
        final List<Integer> l = new LinkedList<>();
        final Random random = new Random();
        for (int i = 0; i < count; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    l.add(random.nextInt());
                }
            };
            thread.start();
            thread.join();
        }


        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        System.out.println(l.size());
    }
}
