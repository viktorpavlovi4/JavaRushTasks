package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int min = Integer.MAX_VALUE;
        FileInputStream fis = new FileInputStream(reader.readLine());
        reader.close();
        while (fis.available() > 0) {
            int re = fis.read();
            if (re < min) {
                min = re;
            }
        }
        fis.close();
        System.out.println(min);
    }
}
