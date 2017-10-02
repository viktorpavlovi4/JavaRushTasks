package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> stringArrayList = new ArrayList<>(5);
        for (int i = 0; i < 5 ; i++) {
            stringArrayList.add(reader.readLine());
        }
        int maxLengthStr = 0;
        for (int i = 0; i < stringArrayList.size(); i++) {
            if (maxLengthStr <= stringArrayList.get(i).length()) {
                maxLengthStr = stringArrayList.get(i).length();
            }
        }
        for (int i = 0; i < stringArrayList.size(); i++) {
            if (maxLengthStr == stringArrayList.get(i).length()){
                System.out.println(stringArrayList.get(i));
            }
        }
    }
}
