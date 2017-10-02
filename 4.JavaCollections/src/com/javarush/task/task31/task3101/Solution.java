package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {
    public static Set<File> files = new TreeSet<>();
    public static void main(String[] args) throws IOException {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParent()+"/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);
        FileOutputStream fos = new FileOutputStream(allFilesContent);
        try {
            deepSearch(path);
            TreeMap<String, File> fileTreeMap = new TreeMap<>();
            for (File file : files) {
                fileTreeMap.put(file.getName(),file);
            }
            for (Map.Entry<String, File> entry : fileTreeMap.entrySet()) {
                BufferedReader reader = new BufferedReader(new FileReader(entry.getValue()));
                String s = "";
                while ((s = reader.readLine()) != null) {
                    fos.write((s+System.lineSeparator()).getBytes());
                }
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fos.close();
        }
    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }

    public static void deepSearch(File f) {
        if (f.isDirectory())
            for (File file : f.listFiles()) {
                deepSearch(file);
            }
        else if (f.isFile()) {
            if (f.length() > 50)
                FileUtils.deleteFile(f);
            else files.add(f);
        }
    }
}
