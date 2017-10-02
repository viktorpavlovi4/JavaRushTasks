package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(f1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(f2));

        String str = "";
        while (fileReader.ready()) {
            str += fileReader.readLine();
        }
        fileReader.close();
        str = str.replaceAll("\\.","!");

        fileWriter.write(str);
        fileWriter.close();
    }
}
