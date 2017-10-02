package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f = reader.readLine();
        reader.close();

        FileReader fr = new FileReader(f);
        int count = 0;
        String s = "";
        while (fr.ready()) {
            s += String.valueOf((char) fr.read());
        }
        fr.close();
        String[] strings = s.split("\\W");
        for (String string : strings) {
            if (string.equals("world"))
                count++;
    }
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i] == 'w' &&
//                    chars[i+1] == 'o' &&
//                    chars[i+2] == 'r' &&
//                    chars[i+3] == 'l' &&
//                    chars[i+4] == 'd')
//                count++;
//        }

        System.out.println(count);
    }
}