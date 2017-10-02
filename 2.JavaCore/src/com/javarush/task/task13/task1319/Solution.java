package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Запись в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new FileWriter(br.readLine()));
        String text;
        while(!(text = br.readLine()).equals("exit")) {
            bw.write(text+ "\n");
        }
        bw.write("exit");
        br.close();
        bw.close();
    }
}
