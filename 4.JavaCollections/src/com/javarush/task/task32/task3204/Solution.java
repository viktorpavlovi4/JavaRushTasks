package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Random r = new Random();
        int n = 0;

        for (int i = 0; i < 8; ++i) {
            char next = 0;
            int range = 10;

//            switch (r.nextInt(3)) {
            switch (n) {
                case 0: {next = 'A'; range = 26;} break;
                case 1: {next = '0'; range = 10;} break;
                case 2: {next = 'a'; range = 26;} break;
                default: {next = 'a'; range = 26;} break;
            }
            n++;
            baos.write((char)((r.nextInt(range)) + next));
        }
        return baos;
    }
}