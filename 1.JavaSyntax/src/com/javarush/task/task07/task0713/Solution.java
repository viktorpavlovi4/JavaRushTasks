package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        ArrayList<Integer> odd3 = new ArrayList<>();
        ArrayList<Integer> odd2 = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            integerArrayList.add(Integer.parseInt(reader.readLine()));
        }

        for (int i = 0; i < integerArrayList.size(); i++) {
            if (integerArrayList.get(i)%3 == 0 && integerArrayList.get(i)%2 == 0 && integerArrayList.get(i) != 0) {
                odd3.add(integerArrayList.get(i));
                odd2.add(integerArrayList.get(i));
            }
            else if (integerArrayList.get(i)%3 == 0 && integerArrayList.get(i) != 0)
            odd3.add(integerArrayList.get(i));
            else if (integerArrayList.get(i)%2 == 0 && integerArrayList.get(i) != 0)
            odd2.add(integerArrayList.get(i));
            else
                odd.add(integerArrayList.get(i));
        }
        printList(odd3);
        printList(odd2);
        printList(odd);
    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
