package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.MIN_VALUE;
        FileInputStream fis = new FileInputStream(reader.readLine());
        reader.close();
        while (fis.available() > 0) {
            int re = fis.read();
            if (re > max) {
                max = re;
            }
        }
        fis.close();
        System.out.println(max);
    }
}
