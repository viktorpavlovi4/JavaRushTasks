package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();

        map.put("01", "2");
        map.put("02", "2");
        map.put("03", "1");
        map.put("04", "1");
        map.put("05", "1");
        map.put("06", "1");
        map.put("07", "1");
        map.put("08", "1");
        map.put("09", "1");
        map.put("00", "н");
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        HashMap<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> e : copy.entrySet()) {
            int n = 0;
            for (Map.Entry<String, String> ee : copy.entrySet()) {
                if (ee.getValue().equals(e.getValue()))
                    n++;
                if (n>1)
                    removeItemFromMapByValue(map, e.getValue());
            }
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
    }
}
