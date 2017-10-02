package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f = reader.readLine();
        reader.close();

        BufferedReader br = new BufferedReader(new FileReader(f));
        StringBuilder sb = new StringBuilder();
        while (br.ready())
        sb.append(br.readLine());
        br.close();
        ArrayList<Integer> start = new ArrayList<>();
        ArrayList<Integer> end = new ArrayList<>();
        //записываем в ArrayList индексы всех открывающих тегов
        int index = 0;
        while (true) {
            index = sb.indexOf("<" + args[0], index);
            if (index == -1) break;
            start.add(index);
            index++;
        }
        //записываем в ArrayList индексы всех закрывающих тегов
        index = 0;
        while (true) {
            index = sb.indexOf("/" + args[0], index);
            if (index == -1) break;
            end.add(index);
            index++;
        }
        //выводим всё это дело в консоль
        while (!start.isEmpty()) {
            int n = 0;
            for (int i = 1; i < start.size(); i++)
                if (start.get(i) < end.get(0))
                    n++;
            System.out.println(sb.substring(start.remove(0), end.remove(n)) + "/" + args[0] + ">");
        }
    }
}
