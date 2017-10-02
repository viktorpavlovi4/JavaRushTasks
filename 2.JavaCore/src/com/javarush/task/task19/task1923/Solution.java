package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fr = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fw = new BufferedWriter(new FileWriter(args[1]));
        String s = "";
        while (fr.ready()) {
            s = fr.readLine();
            String[] strings = s.split(" ");
            for (String ss : strings) {
                if (ss.matches(".*\\d.*")) {
//                    System.out.println(ss);
                    fw.write(ss + " ");
                }
            }
        }
        fr.close();
        fw.close();
    }
}
