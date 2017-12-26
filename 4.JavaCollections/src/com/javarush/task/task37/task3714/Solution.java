package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String roman) {
        final int[] NUMBER_VALUES = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 }; // array containing all of the values
        final String[] NUMBER_LETTERS = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" }; // array containing all of the numerals
        for (int i = 0; i < NUMBER_LETTERS.length; i++) { // Loop through all the letters
            if(roman.startsWith(NUMBER_LETTERS[i])) // Check if the string starts with that letter
                return NUMBER_VALUES[i] + romanToInteger(roman.replaceFirst(NUMBER_LETTERS[i], "")); // Repeats until the string is empty and return it
        }
        return 0; // If something went wrong, simply return 0
    }
}
