package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fIn = new FileInputStream(args[0]);
        byte[] text = new byte[fIn.available()];
        fIn.read(text);

        for (int i = 0; i < 128; i++) {
            int count = 0;
            for (byte b : text) {
                if (b == i)
                    count++;
            }
            if (count > 0)
                System.out.println((char) i + " " + count);
        }

        fIn.close();
    }
}
