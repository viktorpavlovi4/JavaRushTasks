package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigDecimal;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try {
            String s = args[0];
            boolean check = true;
            for (int i = 2; i < 37; i++) {
                try {
                    new BigDecimal(new BigInteger(s, i));
                    System.out.println(i);
                    check = false;
                    break;
                } catch (Exception e) {
                }
            }
            if (check) {
                System.out.println("incorrect");
            }
        } catch (Exception e) {}
    }
}