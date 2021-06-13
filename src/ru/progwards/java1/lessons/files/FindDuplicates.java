package ru.progwards.java1.lessons.files;

import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.io.File;
import java.io.IOException;

public class FindDuplicates {
    List<Path> allFiles = new ArrayList<>();

    public List<List<String>> findDuplicates(String startPath) throws IOException {
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**");

        Files.walkFileTree(Paths.get(startPath), new SimpleFileVisitor<>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (pathMatcher.matches(file))
                    allFiles.add(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        });
        duplicatesSearch(allFiles);
        return null;
    }
    // узнать расширение файла
    static String fileExpansion(Path fileName){
        String expansion = String.valueOf(fileName);
        int index = expansion.lastIndexOf(".");
        return expansion.substring(index + 1);
    }

    // найти дубликаты
    static List<List<String>> duplicatesSearch (List<Path> pathList) throws IOException {
        List<List<String>> allDuplicates = new ArrayList<>(); // потом добавляем этот список в список списков
        while (pathList.size() > 1){
            List<String> fileInfo = new ArrayList<>(); // список для записи одинаковых файлов
            for (int i = 0; i < pathList.size(); i++) {
                fileInfo.add(String.valueOf(pathList.get(0).getFileName()));
                if (Files.getLastModifiedTime(pathList.get(0)).equals(Files.getLastModifiedTime(pathList.get(i))) &&
                        Files.size(pathList.get(0)) == Files.size(pathList.get(i)) &&
                        Files.readString(pathList.get(0)).equals(Files.readString(pathList.get(i))) &&
                        fileExpansion(pathList.get(0)).equals(fileExpansion(pathList.get(i)))){
                    fileInfo.add(String.valueOf(pathList.get(i).getFileName()));
                }
            }
            pathList.remove(0);
            allDuplicates.add(fileInfo);
            fileInfo.clear();
        }
        for (int i = 0; i < allDuplicates.size(); i++) {
            if (allDuplicates.get(i).size() < 2){
                allDuplicates.remove(i);
                i--;
            }
        }
        return allDuplicates;
    }


    public static void main(String[] args) throws IOException {

    }

}

