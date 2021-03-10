package ru.progwards.java1.lessons.maps;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Реализовать класс, подсчитывающий частоту использования слов и букв в словах на основе текстов.
public class UsageFrequency {
    private Map<String, Integer> mapForWords = new HashMap<>();

    //загрузить содержимое файла
    public void processFile(String fileName) throws FileNotFoundException {
        FileReader fileReader = new FileReader(fileName);
        Scanner scanner = new Scanner(fileReader);

    }

    //вернуть Map, который содержит все найденные буквы и цифры, и количество раз,
    // которое встретился каждый искомый символ. Знаки препинания, такие как “.,!? @” и др не учитывать.
    public Map<Character, Integer> getLetters() throws FileNotFoundException {
        Map<Character, Integer> mapForLetters = new HashMap<>();
        UsageFrequency usageFrequency = new UsageFrequency();
        usageFrequency.processFile("wiki.train.tokens");
        while (scanner.hasNext()){
            if (Character.isAlphabetic(scanner.next().charAt(0)) || scanner.hasNextInt()){
                char ch = scanner.next().charAt(0);
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
}
