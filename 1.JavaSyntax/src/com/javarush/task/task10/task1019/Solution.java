package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();

        while (true) {
            String s = reader.readLine();
            if (s.equals("")) break;
            String s1 = reader.readLine();
            int id = Integer.parseInt(s);
            String name = s1;
            map.put(name, id);
//            System.out.println("Id=" + id + " Name=" + name);
        }

        Set<Map.Entry<String, Integer>> set = map.entrySet();
        for (Map.Entry<String, Integer> entry : set) {
            System.out.print(entry.getValue() + " ");
            System.out.println(entry.getKey());
        }
    }
}
