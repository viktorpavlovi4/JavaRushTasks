package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length < 2)
            return;

        String resultFileName = args[0];
        String[] partsOfZip = Arrays.copyOfRange(args, 1, args.length);
        Arrays.sort(partsOfZip);

        Vector files = new Vector(partsOfZip.length);
        try {
            for (String s : partsOfZip) {
                files.addElement(new FileInputStream(s));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        try (ZipInputStream zipIn = new ZipInputStream(new SequenceInputStream(files.elements()));
             FileOutputStream fileOut = new FileOutputStream(new File(resultFileName))) {
            ZipEntry entry = null;
            while ((entry = zipIn.getNextEntry()) != null) {
                byte[] buffer = new byte[1024];
                int l;
                while ((l = zipIn.read(buffer)) > 0) {
                    fileOut.write(buffer, 0, l);
                    fileOut.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
