package com.javarush.task.task30.task3009;

import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number) {
        Set<Integer> set = new HashSet<>();
        int count;
        try {
            count = Integer.parseInt(number);
            for (int i = 2; i < 37; i++) {
                try {
                    String line = Integer.toString(count, i);
                    String reversedLine = new StringBuilder(line.substring(0, line.length()/2)).reverse().toString();
                    if (line.length() % 2 == 0) {
                        if (reversedLine.equals(line.substring(line.length() / 2)))
                            set.add(i);
                    }
                    else {
                        if (reversedLine.equals(line.substring(line.length() / 2 + 1)))
                            set.add(i);
                    }
                } catch (NumberFormatException e) {}

            }
        } catch (NumberFormatException e) {}

        return set;
    }
}