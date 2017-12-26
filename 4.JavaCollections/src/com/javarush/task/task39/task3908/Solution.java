package com.javarush.task.task39.task3908;

import java.util.*;

/*
Возможен ли палиндром?
*/
public class Solution {
    public static void main(String[] args) {
        System.out.print(isPalindromePermutation("lazerrezal"));
    }

    public static boolean isPalindromePermutation(String s) {
        if (s == null || s.isEmpty()) return false;
        String ss = s.toLowerCase().trim();

        Character[] ch = new Character[ss.length()];
        for (int i = 0; i < ss.length(); i++) {
            ch[i] = ss.charAt(i);
        }

        List<Character> asList = Arrays.asList(ch);
        Set<Character> mySet = new HashSet(asList);
        int i = 0;
        for (Character character : mySet) {
            if (Collections.frequency(asList, character) % 2 != 0) i++;
        }

        return i > 1 ? false : true;
    }
}