package cn.wanlinus.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wanli
 * @date 2018-08-09 15:27
 */
public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        int count = Num.num200k;

        final List<Integer> l = new LinkedList<>();
        ThreadPoolExecutor tp = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(count));
        final Random random = new Random();
        for (int i = 0; i < count; i++) {
            tp.execute(() -> {
                l.add(random.nextInt());
            });
        }
        tp.shutdown();
        tp.awaitTermination(1, TimeUnit.DAYS);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        System.out.println(l.size());
    }
}
