package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FilesSelect {

    List<Path> allNeedFiles = new LinkedList<>(); // список с путями всех файлов с текущего каталога

    public void selectFiles(String inFolder, String outFolder, List<String> keys){
        try {
            PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**/.txt");

            Files.walkFileTree(Paths.get(inFolder), new SimpleFileVisitor<>(){
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (pathMatcher.matches(file) && isContainKey(file, keys))
                        allNeedFiles.add(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
            });

            for (Path path : allNeedFiles){
                Path outFolderFilePath = Paths.get(outFolder + "/" + keyWord(path, keys));
                Files.copy(path, outFolderFilePath);
            }
        } catch (IOException e){
            throw new UncheckedIOException(e);
        }
    }

    static boolean isContainKey (Path path, List<String> keys) throws IOException {
        for (String key : keys){
            if (Files.readString(path).contains(key)){
                return true;
            }
        }
        return  false;
    }

    static String keyWord (Path path, List<String> keys) throws IOException {
        String isKey = "";
        for (String key : keys){
            if (Files.readString(path).contains(key)){
                isKey = key;
                break;
            }
        }
        return isKey;
    }

    public static void main(String[] args) {
        FilesSelect filesSelect = new FilesSelect();
        List<String> words = new ArrayList<>();
        words.add("file1");
        words.add("file3");
        filesSelect.selectFiles("C:/Users/Марина/IdeaProjects/HelloWorld/test/", "C:/Users/Марина/IdeaProjects/HelloWorld/test/path1", words);
    }
}
