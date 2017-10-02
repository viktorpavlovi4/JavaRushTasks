package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        double spaceCount = 0;
        double symbolCount = 0;
        double d;
        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            if (data == (byte)' ')
                spaceCount++;
            symbolCount++;
        }
        d = spaceCount/symbolCount*100;
        System.out.println(String.format("%.2f", d));
        fileInputStream.close();
    }
}
