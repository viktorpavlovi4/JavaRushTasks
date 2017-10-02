package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fr = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fw = new BufferedWriter(new FileWriter(args[1]));
        StringBuilder sb = new StringBuilder();
        while (fr.ready()) {
            String[] strings = fr.readLine().split(" ");
            for (int i = 0; i < strings.length; i++) {
                if (strings[i].length() > 6) {
                    sb.append(strings[i]+",");
                }
            }
        }
        fw.write(sb.deleteCharAt(sb.length()-1).toString());
        fr.close();
        fw.close();
    }
}
