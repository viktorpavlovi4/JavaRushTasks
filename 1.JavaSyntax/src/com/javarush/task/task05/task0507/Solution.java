package com.javarush.task.task05.task0507;
/*
Среднее арифметическое
*/
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        int s = 0;
        int c = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int a = scanner.nextInt();
            if (a == -1)
                break;
            else
                s += a;
            c++;
        }
        float sr = (float)s/c;
        System.out.println(sr);
    }
}

/*package com.javarush.task.task05.task0507;

*//*
Среднее арифметическое
*//*

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //напишите тут ваш код
        int count = 0;
        int sum = 0;
        while (true)
        {
            int n = Integer.parseInt(reader.readLine());
            if (n == -1)
            {
                double itog = (double) sum / count;
                System.out.println(itog);
                break;
            }
            else
            {
                sum = sum + n;
                count = count + 1;
            }
        }
    }
}*/

