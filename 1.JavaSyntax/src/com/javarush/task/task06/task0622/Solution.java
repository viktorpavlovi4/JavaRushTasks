package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //напишите тут ваш код
        ArrayList<Integer> n = new ArrayList<>();

        for (int i=0; i<5; i++) {
            n.add(Integer.parseInt(reader.readLine()));
        }

        Collections.sort(n);

        for (int i=0; i<n.size(); i++) {
            System.out.println(n.get(i));
        }

    }
}
