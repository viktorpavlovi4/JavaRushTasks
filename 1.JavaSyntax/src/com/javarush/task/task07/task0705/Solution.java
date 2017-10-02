package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int[] n = new int[20];
        int[] a = new int[10];
        int[] b = new int[10];

        for (int i=0; i<n.length; i++) {
            n[i] = sc.nextInt();
        }

        for (int i=0; i<a.length; i++) {
            a[i] = n[i];
        }
        for (int i=0; i<b.length; i++) {
            b[i] = n[i+10];
            System.out.println(b[i]);
        }
    }
}
