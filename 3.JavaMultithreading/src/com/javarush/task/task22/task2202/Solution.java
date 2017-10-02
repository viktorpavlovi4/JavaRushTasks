package com.javarush.task.task22.task2202;

import java.util.ArrayList;
import java.util.List;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null)
            throw new TooShortStringException();
        String result = "";
        String[] strings = string.split(" ");
        List<Integer> indexesOfSpace = new ArrayList<>();
        char[] temp = string.toCharArray();
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == ' ') {
                indexesOfSpace.add(i);
            }
        }
        if (indexesOfSpace.size() < 4)
            throw new TooShortStringException();
//        else
//        result = string.substring(indexesOfSpace.get(0) + 1, indexesOfSpace.get(4)-1);

        for (int i = 1; i < 5; i++) {
            result += strings[i] + " ";
        }

        return result.trim();
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
