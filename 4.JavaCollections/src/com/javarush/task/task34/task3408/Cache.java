package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();

    public V getByKey(K key, Class<V> clazz) throws Exception {
        if (cache.get(key) != null)
            return cache.get(key);
        Constructor<V> constructor = clazz.getDeclaredConstructor(key.getClass());
        cache.put(key, constructor.newInstance(key));
        return cache.get(key);
    }

    public boolean put(V obj) {
        Method method = null;
        try {
            method = obj.getClass().getDeclaredMethod("getKey");
            method.setAccessible(true);
            cache.put((K) method.invoke(obj), obj);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public int size() {
        return cache.size();
    }
}
