package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader br = new BufferedReader(new FileReader(reader.readLine()));
            reader.close();

            StringBuilder strb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                strb.append(line).append(" ");
            }
            br.close();

            strb = getLine(strb.toString().split(" "));
            System.out.println(strb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static StringBuilder getLine(String... words) {
        if (words == null || words.length == 0)
            return new StringBuilder();
        if ("".equals(words[0]) || words.length == 1)
            return new StringBuilder(words[0]);

        List<String> list = new ArrayList<>();
        for (String word : words) {
            list.add(word);
        }
        boolean isCorrect;
        while (true) {
            Collections.shuffle(list);
            isCorrect = true;
            for (int i = 0; i < list.size(); i++) {
                if ((i+1) != list.size()) {
                    if (!list.get(i).substring(list.get(i).length()-1).toLowerCase().equals(list.get(i+1).substring(0,1).toLowerCase())) {
                        isCorrect = false;
                        break;
                    }
                }
            }
            if (isCorrect)
                break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            sb.append(" ").append(list.get(i));
        }
        return sb;
    }
}
