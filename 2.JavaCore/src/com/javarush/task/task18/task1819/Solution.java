package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String f1 = reader.readLine();
        String f2 = reader.readLine();

        reader.close();

        FileInputStream fileInputStream1 = new FileInputStream(f1);
        FileInputStream fileInputStream2 = new FileInputStream(f2);

        String s = "";
        while (fileInputStream1.available() > 0)
            s += (char)fileInputStream1.read();
        fileInputStream1.close();
        FileOutputStream fileOutputStream = new FileOutputStream(f1);

        while (fileInputStream2.available() > 0) {
            fileOutputStream.write(fileInputStream2.read());
        }
        fileInputStream2.close();
//        fileOutputStream.write(s.getBytes());
        fileOutputStream.close();

        FileWriter fw = new FileWriter(f1, true);
        fw.write(s);
        fw.close();
    }
}
