package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        String[] strings = getTokens("level22.lesson13.task01", ".");
        for (String s : strings) {
            System.out.println(s);
        }

    }
    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer st = new StringTokenizer(query, delimiter);
        String[] strings = new String[st.countTokens()];
        if (query != null && delimiter != null && query.length() != 0) {
            while (st.hasMoreElements()) {
                for (int i = 0; i < strings.length; i++) {
                    strings[i] = st.nextToken();
                }
            }
        }
        return strings;
    }
}
