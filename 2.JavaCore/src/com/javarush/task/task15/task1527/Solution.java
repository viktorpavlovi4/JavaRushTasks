package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        reader.close();
        String[] list = (URI.create(s).getQuery()).split("&");
        for (String s1 : list) {
            System.out.println(s1);
        }
        String value = null;
        for (int i = 0; i < list.length; i++) {
            if (list[i].split("=")[0].equals("obj"))
                value = list[i].split("=")[1];
            System.out.println(list[i].split("=")[0]);
        }
        if (value != null)
            try {
                System.out.println();
                alert(Double.parseDouble(value));
            } catch (Exception e) {
                System.out.println();
                alert(value);
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
