package com.javarush.task.task08.task0827;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        Date date1 = new Date(date);
        long finish = date1.getTime();
        date1.setDate(1);
        date1.setMonth(0);
        long start = date1.getTime();
        long dif = finish - start;
        long day = 24*60*60*1000;
        int days = (int)(dif/day);
        if (days % 2 == 0)
            return true;
        else
            return false;
    }
}
