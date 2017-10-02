package com.javarush.task.task20.task2025;

import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
//        return result;
        List list = ArmstrongNumberMultiSetLongOpt.generate((int) (Math.log10(N)));
        long[] result = new long[list.size()];
//        return list.stream().mapToLong(i -> i).toArray();
        for (int i = 0; i < list.size(); i++) {
            result[i] = Long.valueOf((Long)list.get(i));
            System.out.println(result[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        getNumbers(Long.MAX_VALUE);
    }
}
