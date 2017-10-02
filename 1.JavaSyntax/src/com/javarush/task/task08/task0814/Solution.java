package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        HashSet<Integer> hashSet = new HashSet<>();

        hashSet.add(0);
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(4);
        hashSet.add(5);
        hashSet.add(6);
        hashSet.add(7);
        hashSet.add(8);
        hashSet.add(9);
        hashSet.add(10);
        hashSet.add(11);
        hashSet.add(12);
        hashSet.add(13);
        hashSet.add(14);
        hashSet.add(15);
        hashSet.add(16);
        hashSet.add(17);
        hashSet.add(18);
        hashSet.add(19);

        return hashSet;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (Integer integer : set) {
            if (integer > 10)
                hashSet.add(integer);
        }

        set.removeAll(hashSet);

        return set;
    }

    public static void main(String[] args) {
    }
}
