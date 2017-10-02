package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("Бах", "Себастян");
        hashMap.put("Гюго", "Виктор");
        hashMap.put("Тесла", "Никола");
        hashMap.put("Чуковский", "Корней");
        hashMap.put("Глюк", "Кристоф");
        hashMap.put("Чайковский", "Пётр");
        hashMap.put("Эйнштейн", "Альберт");
        hashMap.put("Неумывакин", "Иван");
        hashMap.put("Ефимов", "Виктор");
        hashMap.put("Рахманинов", "Сергей");
        return hashMap;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int n = 0;
        for (String s : map.values()) {
            if (s.equals(name)) n++;
        }
        return n;
    }


    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        int n = 0;
        for (String s : map.keySet()) {
            if (s.equals(lastName)) n++;
        }
        return n;
    }

    public static void main(String[] args) {
    }
}
