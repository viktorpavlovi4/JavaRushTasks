package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();

        reader.close();

        FileInputStream f1 = new FileInputStream(s1);
        FileOutputStream fos2 = new FileOutputStream(s2);
        FileOutputStream fos3 = new FileOutputStream(s3);

        while (f1.available() > 0) {
            byte[] buffer = new byte[f1.available()];
            int count = f1.read(buffer);
            fos2.write(buffer, 0, (count+1)/2);
            fos3.write(buffer, (count+1)/2, count/2);
        }

        f1.close();
        fos2.close();
        fos3.close();
    }
}
