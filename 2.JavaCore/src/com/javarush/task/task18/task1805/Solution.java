package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        reader.close();

        int[] bytes = new int[256];

        while (fis.available() > 0) {
            int n = fis.read();
            for (int i = 0; i < bytes.length; i++) {
                if (n == i)
                    bytes[i]++;
            }
        }

        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] > 0)
                System.out.print(i+" ");
        }

        fis.close();
    }
}