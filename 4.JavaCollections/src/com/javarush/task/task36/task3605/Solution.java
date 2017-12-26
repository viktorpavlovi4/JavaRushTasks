package com.javarush.task.task36.task3605;

import java.io.*;
import java.util.Iterator;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0]))));
        TreeSet<String> alphabet = new TreeSet<>();

        while (reader.ready()) {
            char[] chars = reader.readLine().toLowerCase().toCharArray();
            for (char c : chars) {
                if (Character.isLetter(c)) {
                    alphabet.add(String.valueOf(c));
                }
            }
        }

        if (alphabet.size() < 5) {
            for (String a : alphabet) {
                System.out.print(a);
            }
        } else {
            Iterator<String> iterator = alphabet.iterator();
            for (int i = 0; i < 5; i++) {
                System.out.print(iterator.next());
            }
        }
    }
}
