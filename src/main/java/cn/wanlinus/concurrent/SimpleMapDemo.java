package cn.wanlinus.concurrent;

import java.util.HashMap;

/**
 * 使用普通的Map容器
 *
 * @author wanli
 * @date 2018-04-11 10:06
 */
public class SimpleMapDemo {
    private HashMap<String, Integer> map = new HashMap<>();

    public synchronized void add(String key) {
        Integer value = map.get(key);
        if (value == null) {
            map.put(key, 1);
        } else {
            map.put(key, value + 1);
        }
    }

    public Integer get(String key) {
        return map.get(key);
    }
}
