package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize = -1;
    private int maxSize = -1;
    private List<Path> foundFiles = new ArrayList<>();

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }
    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }
    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }
    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean contains = true;
        String content = new String(Files.readAllBytes(file));

        if (partOfName != null && !file.getFileName().toString().contains(partOfName))
            contains = false;

        if (partOfContent != null && !content.contains(partOfContent))
            contains = false;

        if (maxSize != -1 && Files.size(file) > (long)maxSize)
            contains = false;

        if (minSize != -1 && Files.size(file) < (long)minSize)
            contains = false;

        if (contains)
            foundFiles.add(file);

        return FileVisitResult.CONTINUE;
    }
}
