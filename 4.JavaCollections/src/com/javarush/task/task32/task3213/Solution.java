package com.javarush.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor Dpljr");
        System.out.println(decode(reader, -3));  //Hello Amigo

    }

    public static String decode(StringReader reader, int key) throws IOException {
        StringWriter stringWriter = new StringWriter();
        int c;
        if (reader != null)
            while ((c = reader.read()) != -1) {
                Character character = (char) (c + key);
//                if (Character.isWhitespace((char) c))
//                    stringWriter.write(Character.valueOf(' '));
//                else
                    stringWriter.write(character);
            }
        return stringWriter.toString();
    }
}
