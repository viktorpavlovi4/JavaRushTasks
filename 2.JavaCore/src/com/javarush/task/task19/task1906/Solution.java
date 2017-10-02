package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        reader.close();

        FileReader fr = new FileReader(f1);
        FileWriter fw = new FileWriter(f2);
        int count = 0;
        while (fr.ready()) {
            int c = fr.read();
            count++;
            if (count % 2 == 0)
                fw.write(c);
        }
        fr.close();
        fw.close();
    }
}
