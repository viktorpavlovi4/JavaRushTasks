package com.javarush.task.task07.task0710;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
В начало списка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> arrlstr = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            arrlstr.add(0, reader.readLine());
        }
        for (int i = 0; i < arrlstr.size(); i++) {
            System.out.println(arrlstr.get(i));
        }
    }
}
