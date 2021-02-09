package ru.progwards.java1.lessons.sets;

import java.util.Set;
import java.util.TreeSet;

public class LettersInFile {


    //вернуть все буквы, которые встретились в файле, сконкатенированные в виде строки.
    // Буквы должны быть упорядочены по алфавиту, типа “ADEF...”.
    // Все возникающие исключения, по работе с потоками, пробросить выше
    public static String process(String fileName){
        Set<String> result = new TreeSet<>();
        StringBuilder resultOnString = new StringBuilder();
        char [] wordSymbols = fileName.toCharArray();
        for (int i = 0; i < wordSymbols.length; i++) {
            if (Character.isAlphabetic(wordSymbols[i]) && Character.isUpperCase(wordSymbols[i])) {
                result.add(String.valueOf(wordSymbols[i]).toUpperCase());
            }
            if (Character.isAlphabetic(wordSymbols[i]) && Character.isLowerCase(wordSymbols[i])) {
                result.add(String.valueOf(wordSymbols[i]).toLowerCase());
            }
        }
        for (String str: result) {
            resultOnString.append(str);
        }
        return String.valueOf(resultOnString);
    }

    public static void main(String[] args) {
        LettersInFile test = new LettersInFile();
        System.out.println(test.process("12A!@ZZXS43cd"));
    }
}
