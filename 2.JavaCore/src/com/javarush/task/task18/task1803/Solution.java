package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        reader.close();

        int[] bytes = new int[256];

        while (fis.available() > 0) {
            int re = fis.read();
            for (int i = 0; i < bytes.length; i++) {
                if (re == i)
                    bytes[i]++;
            }
        }
        int max = 0;
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] > max)
                max = bytes[i];
        }

        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == max)
                System.out.print(i+" ");
        }

        fis.close();
    }
}
