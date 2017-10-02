package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f = reader.readLine();
        reader.close();
        BufferedReader fr = new BufferedReader(new FileReader(f));

        while (fr.ready()) {
            String s = fr.readLine().trim();
            int count = 0;
            for (int i = 0; i < words.size(); i++) {
                if (s.contains(words.get(i)))
                    count++;
            }
            if (count == 2)
                System.out.println(s);
        }

        fr.close();
    }
}
