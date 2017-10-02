package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        while (!s.equals("exit")) {
            new ReadThread(s).start();
            s = reader.readLine();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        String fileName;

        public ReadThread(String fileName) throws IOException {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try {
                byte[] bytes = new byte[256];
                FileInputStream fis = new FileInputStream(fileName);
                byte[] text = new byte[fis.available()];
                fis.read(text);

                for (int i = 0; i < bytes.length; i++) {
                    for (byte b : text) {
                        if (b == i)
                            bytes[i]++;
                    }
                }

                int max = 0;
                for (int i = 0; i < bytes.length; i++) {
                    if (bytes[i] > max)
                        max = bytes[i];
                }

                for (int i = 0; i < bytes.length; i++) {
                    if (bytes[i] == max)
                        resultMap.put(fileName, i);
                }

                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
