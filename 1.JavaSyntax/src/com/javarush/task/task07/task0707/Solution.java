package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> stringArrayList = new ArrayList<>(5);
        stringArrayList.add("0000");
        stringArrayList.add("1111");
        stringArrayList.add("2222");
        stringArrayList.add("3333");
        stringArrayList.add("4444");
        System.out.println(stringArrayList.size());
        for (int i = 0; i < stringArrayList.size(); i++) {
            System.out.println(stringArrayList.get(i));
        }
    }
}
