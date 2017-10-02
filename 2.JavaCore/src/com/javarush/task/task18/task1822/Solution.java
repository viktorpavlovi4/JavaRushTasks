package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        reader.close();

        BufferedReader fr = new BufferedReader(new FileReader(f1));
        String s;
        while (true) {
            s = fr.readLine();
            if (s.split(" ")[0].equals(args[0])) {
                System.out.println(s);
                break;
            }
        }
        fr.close();
    }
}
