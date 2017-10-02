package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String f1 = reader.readLine();
        String f2 = reader.readLine();
        String f3 = reader.readLine();

        reader.close();

        FileOutputStream fileOutputStream = new FileOutputStream(f1);
        FileInputStream fileInputStream2 = new FileInputStream(f2);
        FileInputStream fileInputStream3 = new FileInputStream(f3);

        while (fileInputStream2.available() > 0) {
            fileOutputStream.write(fileInputStream2.read());
        }
        fileOutputStream.flush();

        while (fileInputStream3.available() > 0) {
            fileOutputStream.write(fileInputStream3.read());
        }

        fileInputStream2.close();
        fileInputStream3.close();
        fileOutputStream.close();
    }
}
