package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        int tmp1;
        int tmp2;

        byte[][] b = a.clone();

        for (int i = 0; i < b.length; i++) {
            for (int j = 0;  j < b.length;  j++) {
                tmp1 = 0;
                tmp2 = 0;
                if (b[i][j] == 1)
                    count++;
                for (int k = j; k < b.length; k++) {
                    if (b[i][k] == 0) {
                        tmp1 = k;
                        break;
                    }
                    tmp1 = b.length;
                }
                for (int k = i; k < b.length; k++) {
                    if (b[k][j] == 0) {
                        tmp2 = k;
                        break;
                    }
                    tmp2 = b.length;
                }
                for (int k = i; k < tmp2; k++) {
                    for (int l = j; l < tmp1; l++) {
                        b[k][l] = 0;
                    }
                }

                /*if (b[i][j+1] == 1 && b[i+1][j] == 1 && b[i+1][j+1] == 1 && b[i][j] == 1) {
                    b[i][j] = 0;
                    b[i][j + 1] = 0;
                    b[i + 1][j] = 0;
                    b[i + 1][j + 1] = 0;
                }*/
            }
        }
        return count;
    }
}