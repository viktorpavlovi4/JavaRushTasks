package com.javarush.test.level04.lesson07.task03;

/* Положительные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных чисел в исходном наборе.
Пример для чисел -4 6 6:
2
Пример для чисел -6 -6 -3:
0
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
        if (i1>0 && i2>0 && i3>0)
            System.out.println(3);
        else if (i1>0 && i2>0 || i1>0 && i3>0 || i2>0 && i3>0)
            System.out.println(2);
        else if (i1>0 || i2>0 || i3>0)
            System.out.println(1);
        else System.out.println(0);
    }
}
