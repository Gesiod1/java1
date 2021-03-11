package ru.progwards.java1.lessons.maps;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Реализовать класс, подсчитывающий частоту использования слов и букв в словах на основе текстов.
public class UsageFrequency {
    StringBuilder strForLetters = new StringBuilder();

    //загрузить содержимое файла
    public void processFile(String fileName) throws FileNotFoundException {
        FileReader fileReader = new FileReader(fileName);
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNextLine()){
            strForLetters.append(scanner.nextLine());
        }
    }

    //вернуть Map, который содержит все найденные буквы и цифры, и количество раз,
    // которое встретился каждый искомый символ. Знаки препинания, такие как “.,!? @” и др не учитывать.
    public Map<Character, Integer> getLetters() throws FileNotFoundException {
        Map<Character, Integer> mapForLetters = new HashMap<>();
        String numbers = "0123456789";
        UsageFrequency usageFrequency = new UsageFrequency();
        usageFrequency.processFile("wiki.train.tokens");
        char[] letters = strForLetters.toString().toCharArray();
        for (int i = 0; i < letters.length; i++) {
            if (Character.isAlphabetic(letters[i]) || numbers.contains(String.valueOf(letters[i]))){
                char ch = letters[i];
                if (mapForLetters.get(ch) == null){
                    mapForLetters.put(ch, 1);
                } else {
                    int oldValue = mapForLetters.get(ch);
                    int newValue = oldValue + 1;
                    mapForLetters.replace(ch, oldValue, newValue);
                }
            }
        }
        return mapForLetters;
    }

    public static void main(String[] args) throws FileNotFoundException {
        UsageFrequency usageFrequency = new UsageFrequency();
        System.out.println(usageFrequency.getLetters());
    }
}
