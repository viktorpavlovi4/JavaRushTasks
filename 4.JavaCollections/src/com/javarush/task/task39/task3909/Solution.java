package com.javarush.task.task39.task3909;

import java.util.Arrays;

/*
Одно изменение
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isOneEditAway("abcd", "avcd"));
    }

    public static boolean isOneEditAway(String first, String second) {
        if (first == null || second == null) return false;
        if (first.equals(second)) return true;
        if (Math.abs(first.length() - second.length()) > 1) return false;

        char[] f = first.toCharArray();
        char[] s = second.toCharArray();

        int l = f.length < s.length ? s.length : f.length;

        if (f.length == s.length) {
            for (int i = 0; i < l; i++) {
                if (f[i] != s[i]) {
                    f[i] = s[i];
                    return Arrays.equals(f, s);
                }
            }
        } else {
            for (int i = 0; i < l; i++) {
                if (i == l - 1) return true;
                if (f[i] != s[i]) {
                    if (f.length > s.length) {
                        return (String.valueOf(Arrays.copyOfRange(f, 0, i)) + String.valueOf(Arrays.copyOfRange(f, i + 1, f.length))).equals(String.valueOf(s));
                    } else {
                        return (String.valueOf(Arrays.copyOfRange(s, 0, i)) + String.valueOf(Arrays.copyOfRange(s, i + 1, s.length))).equals(String.valueOf(f));
                    }
                }
            }
        }
        return false;
    }
}