package com.javarush.task.task19.task1926;

/* 
Перевертыши
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

        BufferedReader fr = new BufferedReader(new FileReader(f));
        while (fr.ready()) {
            StringBuilder str = new StringBuilder(fr.readLine());
            System.out.println(str.reverse());
        }
        fr.close();
    }
}
