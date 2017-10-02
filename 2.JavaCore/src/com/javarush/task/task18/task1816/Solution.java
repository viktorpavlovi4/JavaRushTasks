package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        int count = 0;
        while (fis.available() > 0) {
            String s = String.valueOf((char) (fis.read()));
            if (Pattern.matches("[a-zA-Z]", s))
                count++;
        }
        System.out.println(count);
        fis.close();
    }
}
