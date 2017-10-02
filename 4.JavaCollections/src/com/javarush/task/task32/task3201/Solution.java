package com.javarush.task.task32.task3201;

import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) {
        try {
            RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
            long number = Integer.parseInt(args[1]);
            String text = args[2];

            raf.seek(number);
            if ((args[0].length() - number - text.length()) >= 0)
                raf.write(text.getBytes());
            else {
                raf.seek(raf.length());
                raf.write(text.getBytes());
            }
        } catch (Exception e) {
        }
    }
}
