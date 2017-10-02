package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i1 = Integer.parseInt(reader.readLine());
        int i2 = Integer.parseInt(reader.readLine());
        int i3 = Integer.parseInt(reader.readLine());
        int a,b;
        if (i1>0 && i2>0 && i3>0) {
            a = 0;
            b = 3;
        }
        else if (i1>0 && i2>0 || i1>0 && i3>0 || i2>0 && i3>0){
            a = 1;
            b = 2;
        }
        else if (i1>0 || i2>0 || i3>0){
            a = 2;
            b = 1;
        }
        else {
            a = 3;
            b = 0;
        }
        System.out.println("количество отрицательных чисел: "+a);
        System.out.println("количество положительных чисел: "+b);
    }
}
