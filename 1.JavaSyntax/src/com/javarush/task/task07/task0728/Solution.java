package com.javarush.task.task07.task0728;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
В убывающем порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array) {
            System.out.println(x);
        }
    }

    public static void sort(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            boolean sorted = true;
            for (int i1 = 0; i1 < array.length-1; i1++) {
                if (array[i1] < array[i1+1]){
                    int tmp = array[i1];
                    array[i1] = array[i1+1];
                    array[i1+1] = tmp;
                    sorted = false;
                }
            }
        if (sorted)
            break;
        }
    }
}
