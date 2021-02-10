package ru.progwards.java1.lessons.sets;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class LettersInFile {


    //вернуть все буквы, которые встретились в файле, сконкатенированные в виде строки.
    // Буквы должны быть упорядочены по алфавиту, типа “ADEF...”.
    // Все возникающие исключения, по работе с потоками, пробросить выше
    public static String process(String fileName) throws FileNotFoundException {
        FileReader fileReader = new FileReader(fileName);
        Scanner scanner = new Scanner(fileReader);

        Set<String> result = new TreeSet<>();
        StringBuilder resultOnString = new StringBuilder();

        while (scanner.hasNextLine()){
            char [] wordSymbols = scanner.nextLine().toCharArray();
            for (int i = 0; i < wordSymbols.length; i++) {
                if (Character.isAlphabetic(wordSymbols[i]) ) {
                    result.add(String.valueOf(wordSymbols[i]));
                }
            }
        }
        for (String str: result) {
            resultOnString.append(str);
        }
        return String.valueOf(resultOnString);
    }

    public static void main(String[] args) throws FileNotFoundException {
        LettersInFile test = new LettersInFile();
        System.out.println(process("forRead.txt"));
    }
}
