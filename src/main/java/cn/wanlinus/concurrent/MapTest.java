package cn.wanlinus.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author wanli
 * @date 2018-04-11 10:18
 */
public class MapTest {

    public static void main(String[] args) {
        ConcurrentMapDemo demo = new ConcurrentMapDemo();
        Runnable runnable = () -> {
            demo.add("value");
        };
        for (int i = 0; i < 20000; i++) {
            runnable.run();
        }
        System.out.println(demo.get("value"));
    }

}
