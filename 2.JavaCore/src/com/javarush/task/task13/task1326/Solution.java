package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        BufferedReader fr = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        FileInputStream fis = new FileInputStream(fileName);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        while (fr.ready()) {
            int i = Integer.parseInt(fr.readLine());
            if (i%2 == 0) {
                arrayList.add(i);
            }
        }
        Collections.sort(arrayList);
        for (Integer integer : arrayList) {
            System.out.println(integer.intValue());
        }
        br.close();
        fis.close();
    }
}
