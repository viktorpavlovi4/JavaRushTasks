package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            FileInputStream fis1 = new FileInputStream(reader.readLine());
//            FileInputStream fis2 = new FileInputStream(reader.readLine());

            allLines = Files.readAllLines(Paths.get(reader.readLine()), StandardCharsets.UTF_8);
            forRemoveLines = Files.readAllLines(Paths.get(reader.readLine()), StandardCharsets.UTF_8);
            reader.close();

            new Solution().joinData();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines))
            allLines.removeAll(forRemoveLines);
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
