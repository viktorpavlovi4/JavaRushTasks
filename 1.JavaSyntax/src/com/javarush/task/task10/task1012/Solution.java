package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        // напишите тут ваш код
        String str = "";
        for (String s : list) {
            str = str.concat(s);
        }
        char[] ch = str.toCharArray();

        ArrayList<Character> chars = new ArrayList<>();
        for (int i = 0; i < ch.length; i++) {
            chars.add(ch[i]);
        }

        for (Character character : alphabet) {
            int count = 0;
            for (Character aChar : chars) {
                if (character.equals(aChar))
                    count++;
            }
            System.out.println(character + " " + count);
        }
    }

}
