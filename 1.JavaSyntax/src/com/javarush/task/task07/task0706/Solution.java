package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int[] m = new int[15];
        int even = 0;
        int odd = 0;

        for (int i=0; i<m.length; i++) {
            m[i] = sc.nextInt();
            if (i%2 == 0)
                even += m[i];
            else odd += m[i];
        }
        if (even < odd) System.out.println("В домах с нечетными номерами проживает больше жителей.");
        else System.out.println("В домах с четными номерами проживает больше жителей.");
    }
}
