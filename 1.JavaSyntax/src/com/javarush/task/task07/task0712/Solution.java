package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> stringArrayList = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            stringArrayList.add(reader.readLine());
        }

        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < stringArrayList.size(); i++) {
            if (max <= stringArrayList.get(i).length())
                max = stringArrayList.get(i).length();
        }

        for (int i = 0; i < stringArrayList.size(); i++) {
            if (min >= stringArrayList.get(i).length())
                min = stringArrayList.get(i).length();
        }

        for (int i = 0; i < stringArrayList.size(); i++) {
            if (min == stringArrayList.get(i).length() || max == stringArrayList.get(i).length()) {
                System.out.println(stringArrayList.get(i));
                break;
            }
        }
    }
}
