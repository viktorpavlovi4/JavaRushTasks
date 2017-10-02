package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        int[] ar1 = {1,2,3,4,5};
        int[] ar2 = {1,2};
        int[] ar3 = {1,2,3,4};
        int[] ar4 = {1,2,3,4,5,6,7};
        int[] ar5 = {};
        ArrayList<int[]> list = new ArrayList<>();
        list.add(ar1);
        list.add(ar2);
        list.add(ar3);
        list.add(ar4);
        list.add(ar5);
        return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
