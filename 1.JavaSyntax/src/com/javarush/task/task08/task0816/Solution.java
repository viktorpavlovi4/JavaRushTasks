package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Stilone", new Date("DECEMBER 1 1990"));
        map.put("Rembo", new Date("SEPTEMBER 1 1970"));
        map.put("Jeki", new Date("AUGUST 1 1960"));
        map.put("Tayson", new Date("MAY 1 1950"));
        map.put("Rikki", new Date("APRIL 1 1940"));
        map.put("Rokki", new Date("MARCH 1 1930"));
        map.put("Balboa", new Date("FEBRUARY 1 2000"));
        map.put("Stilloving", new Date("JANUARY 1 1980"));
        map.put("You", new Date("JULY 1 1980"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap map) {
        Iterator<Map.Entry<String, Date>> it = map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String, Date> val = it.next();
            if (val.getValue().getMonth() > 4 && val.getValue().getMonth() < 8) it.remove();
        }
    }

    public static void main(String[] args) {
    }
}
