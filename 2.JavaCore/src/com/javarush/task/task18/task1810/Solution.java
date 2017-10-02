package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis;
        String s;
        byte[] buffer;
        int count;
            do {
                s = reader.readLine();
                fis = new FileInputStream(s);
                buffer = new byte[fis.available()];
                count = fis.read(buffer);
            } while (count >= 1000);
        fis.close();
        reader.close();
        throw new DownloadException();
    }

    public static class DownloadException extends Exception {

    }
}
