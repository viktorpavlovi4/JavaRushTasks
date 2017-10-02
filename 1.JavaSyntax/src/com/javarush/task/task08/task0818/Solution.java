package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("00", 1);
        map.put("01", 1);
        map.put("02", 1);
        map.put("03", 500);
        map.put("04", 1500);
        map.put("05", 1000);
        map.put("06", 501);
        map.put("07", 100);
        map.put("08", 499);
        map.put("09", 10);

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        HashMap<String, Integer> copy = new HashMap<>(map);

        for (Map.Entry<String, Integer> e : copy.entrySet()) {
            if (e.getValue() < 500)
                map.remove(e.getKey());
        }
    }

    public static void main(String[] args) {
    }
}