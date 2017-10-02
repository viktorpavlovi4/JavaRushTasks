package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[1]);
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        fis.close();
        FileOutputStream fos = new FileOutputStream(args[2]);
        if (args[0].equals("-e")) {
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i] = --buffer[i];
                }
                fos.write(buffer);
                fos.close();
        }
        else if (args[0].equals("-d")){
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i] = ++buffer[i];
                }
                fos.write(buffer);
                fos.close();
        }
    }
}
