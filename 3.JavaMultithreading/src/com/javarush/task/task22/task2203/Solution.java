package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null)
            throw new TooShortStringException();

        int i = string.indexOf("\t");
        int j = string.indexOf("\t",i+1);
        if (i == -1 || j == -1)
            throw new TooShortStringException();

        String result = string.substring(i+1,j);

        return result;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
