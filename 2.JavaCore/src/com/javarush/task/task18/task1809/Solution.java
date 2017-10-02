package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        reader.close();

        FileInputStream fis = new FileInputStream(s1);
        FileOutputStream fos = new FileOutputStream(s2);

        while (fis.available() > 0) {
            byte[] buffer = new byte[fis.available()];
            int count = fis.read(buffer);
            for (int i = buffer.length - 1; i >= 0; i--) {
                fos.write(buffer[i]);
            }
        }

        fis.close();
        fos.close();
    }
}
