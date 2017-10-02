package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("мама");
        stringArrayList.add("мыла");
        stringArrayList.add("раму");
        for (int i = 0; i < 6; i++) {
            stringArrayList.add(i+1,"именно");
            i++;
        }

        for (int i = 0; i < stringArrayList.size(); i++) {
            System.out.println(stringArrayList.get(i));
        }

    }
}
