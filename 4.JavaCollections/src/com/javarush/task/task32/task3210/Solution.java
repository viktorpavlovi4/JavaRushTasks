package com.javarush.task.task32.task3210;

import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            byte[] buffer = new byte[text.length()];
            raf.seek(number);
            raf.read(buffer, 0, buffer.length);
            String read = convertByteToString(buffer);
            String write = read.equals(text) ? "true" : "false";
            raf.seek(raf.length());
            raf.write(write.getBytes());
        } catch (Exception e) {

        }
    }

    public static String convertByteToString(byte readBytes[]) {
        //return new String(readBytes, StandardCharsets.UTF_8);
        return new String(readBytes);
    }
}
