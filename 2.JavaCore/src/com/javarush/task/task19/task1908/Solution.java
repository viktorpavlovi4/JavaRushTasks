package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        reader.close();

        BufferedReader fr = new BufferedReader(new FileReader(f1));
        BufferedWriter fw = new BufferedWriter(new FileWriter(f2));

        StringBuilder stringBuilder = new StringBuilder("");
        while (fr.ready()){
            stringBuilder.append(fr.readLine());
        }
        fr.close();


        String[] strings = String.valueOf(stringBuilder).split("\\s");
//        String[] strings = String.valueOf(stringBuilder).split("\\D");
        String str = "";
        for (String s : strings) {
            if (s.matches("^\\d+$")) {
                str += " "+ s;
            }
        }
        fw.write(str.trim());
        fw.close();
    }
}
