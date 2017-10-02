package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        reader.close();

        FileInputStream fis = new FileInputStream(f1);
        byte[] bytes = new byte[fis.available()];
        fis.read(bytes);
        fis.close();

        FileOutputStream fos = new FileOutputStream(f2);
        String[] numbers = new String(bytes).split(" ");
        String line = "";
        for (String s : numbers) {
            line += Math.round(Float.parseFloat(s))+" ";
        }
        fos.write(line.trim().getBytes());
        fos.close();
    }
}
