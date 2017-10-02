package com.javarush.test.level04.lesson04.task07;

/* Количество дней в году
Ввести с клавиатуры год, определить количество дней в году. Результат вывести на экран в следующем виде:
"количество дней в году: x", где х - 366 для високосными года, х - 365 для обычного года.
Подсказка: В високосном году - 366 дней, тогда как в обычном  - 365.
Високосным годом является каждый четвёртый год, за исключением столетий, которые не кратны 400.
Так, годы 1700, 1800 и 1900 не являются високосными, так как они кратны 100 и не кратны 400.
Годы 1600 и 2000 — високосные, так как они кратны 100 и кратны 400.
Годы 2100, 2200 и 2300 — невисокосные.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String y = reader.readLine();
        int i = Integer.parseInt(y);
        if (i % 4 == 0) {
            if (i % 400 == 0 && i % 100 == 0)
            System.out.println("количество дней в году: 366");
            else if (i % 100 != 0)
            System.out.println("количество дней в году: 366");
            else
                System.out.println("количество дней в году: 365");
        } else System.out.println("количество дней в году: 365");
    }
}