package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i1 = Integer.parseInt(reader.readLine());
        int i2 = Integer.parseInt(reader.readLine());
        int i3 = Integer.parseInt(reader.readLine());
        while (i1>i2 && i1>i3) {
            if (i2 > i3)
                System.out.println(i2);
            else System.out.println(i3);
            break;
        }
        while (i2>i1 && i2>i3){
            if (i1>i3) {
                System.out.println(i1);
            }
            else System.out.println(i3);
            break;
        }
        while (i3>i1 && i3>i2){
            if (i1>i2) {
                System.out.println(i1);
            }
            else System.out.println(i2);
            break;
        }
    }
}
