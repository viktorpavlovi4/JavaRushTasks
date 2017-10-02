package com.javarush.task.task31.task3113;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/
public class Solution {
    static int folders = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        reader.close();
        Path path = Paths.get(s);

        if (!Files.isDirectory(path)) {
            System.out.println(path.toString()+" - не папка");
            return;
        }

        AtomicLong size = new AtomicLong(0);

        final int[] fileNumber = {0};

        /*path.toFile().listFiles();
        for (File file : path.toFile().listFiles()) {
            if (file.isDirectory())
                folders++;
        }*/

        Files.walkFileTree(path, new SimpleFileVisitor() {
            @Override
            public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
                size.addAndGet(attrs.size());
                fileNumber[0]++;
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {
                folders++;
                return FileVisitResult.CONTINUE;
            }
        });

        System.out.println("Всего папок - "+folders);
        System.out.println("Всего файлов - "+fileNumber[0]);
        System.out.println("Общий размер - "+size);
    }
}
