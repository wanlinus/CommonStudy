package cn.wanlinus.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author wanli
 * @date 2018-04-11 10:12
 */
public class ConcurrentMapDemo {
    private ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();

    public void add(String key) {
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
