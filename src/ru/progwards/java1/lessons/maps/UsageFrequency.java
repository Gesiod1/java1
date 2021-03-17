package ru.progwards.java1.lessons.maps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

//Реализовать класс, подсчитывающий частоту использования слов и букв в словах на основе текстов.
//public class UsageFrequency {
//    StringBuilder strForLetters = new StringBuilder();
//
//    //загрузить содержимое файла
//    public void processFile(String fileName) {
//        try {
//            FileReader fileReader = new FileReader(fileName);
//            Scanner scanner = new Scanner(fileReader);
//            while (scanner.hasNextLine()){
//                strForLetters.append(scanner.nextLine());
//            }
//        } catch (FileNotFoundException e){
//            System.out.println(e);
//        }
//    }
//
//    //вернуть Map, который содержит все найденные буквы и цифры, и количество раз,
//    // которое встретился каждый искомый символ. Знаки препинания, такие как “.,!? @” и др не учитывать.
//    public Map<Character, Integer> getLetters() throws FileNotFoundException {
//        Map<Character, Integer> mapForLetters = new TreeMap<>();
//        String numbers = "0123456789";
//        char[] letters = strForLetters.toString().toCharArray();
//        for (int i = 0; i < letters.length; i++) {
//            if (Character.isAlphabetic(letters[i]) || numbers.contains(String.valueOf(letters[i]))){
//                char ch = letters[i];
//                if (mapForLetters.get(ch) == null){
//                    mapForLetters.put(ch, 1);
//                } else {
//                    int oldValue = mapForLetters.get(ch);
//                    int newValue = oldValue + 1;
//                    mapForLetters.replace(ch, oldValue, newValue);
//                }
//            }
//        }
//        return mapForLetters;
//    }
//
//    //вернуть Map, который содержит все найденные слова и количество раз, которое каждое слово встретилось.
//    // Знаки препинания, такие как “.,!? @” и др являются разделителями.
//    private static String[] convertStringToWordArray(StringBuilder stringBuilder) {
//        String allText = stringBuilder.toString();
//        return allText.split(" ");
//    }
//
//    private static String getWordWithoutEndingSymbols(String word) {
//        String numbers = "0123456789";
//        Integer amountOfSymbols = 0;
//        char [] wordSymbols = word.toCharArray();
//        for (int i = wordSymbols.length - 1; i > 0; i--) {
//            if (!Character.isAlphabetic(wordSymbols[i]) ) {
//                amountOfSymbols++;
//            } else {
//                break;
//            }
//        }
//        return word.substring(0, wordSymbols.length - amountOfSymbols);
//    }
//
//    public Map<String, Integer> getWords(){
//        Map<String, Integer> mapForWords = new TreeMap<>();
//        String [] allWords = convertStringToWordArray(strForLetters);
//        String numbers = "0123456789";
//        for (int i = 0; i < allWords.length; i++) {
////            String word = getWordWithoutEndingSymbols(allWords[i]);
//            char[] wordWithSymbols = allWords[i].toCharArray();
//            if (wordWithSymbols.length == 0 ||
//                    (!Character.isAlphabetic(wordWithSymbols[0]) && !numbers.contains(String.valueOf(wordWithSymbols[0]))) ||
//                    (!Character.isAlphabetic(wordWithSymbols[wordWithSymbols.length-1]) && !numbers.contains(String.valueOf(wordWithSymbols[wordWithSymbols.length-1])))){
//                continue;
//            } else {
//                if (mapForWords.get(allWords[i]) == null){
//                    mapForWords.put(allWords[i], 1);
//                } else {
//                    int oldValue = mapForWords.get(allWords[i]);
//                    int newValue = oldValue + 1;
//                    mapForWords.replace(allWords[i], oldValue, newValue);
//                }
//            }
//        }
//        return mapForWords;
//    }
//
//    public static void main(String[] args) throws FileNotFoundException {
//        UsageFrequency usageFrequency = new UsageFrequency();
//        usageFrequency.processFile("wiki.test.tokens"); // wiki.train.tokens
////        System.out.println(usageFrequency.getLetters());
//        System.out.println(usageFrequency.getWords());
//    }
//}

public class UsageFrequency
{
    List<String> list = new ArrayList<>();

    public void processFile(String fileName) //throws FileNotFoundException
    //- загрузить содержимое файла
    {
        try (Scanner in = new Scanner(new File(fileName)))
        {
            while (in.hasNext())
            {
                String s = in.next();
                StringBuilder sb = new StringBuilder();

                for (char c : s.toCharArray())
                    if (Character.isLetterOrDigit(c))
                        sb.append(c);

                if (sb.length() > 0)
                    list.add(sb.toString());
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public Map<Character, Integer> getLetters()
//        который содержит все найденные буквы и цифры, и количество раз,
//        которое встретился каждый искомый символ. Знаки препинания, такие как “.,!? @” и
//        др не учитывать.
    {
        Map<Character, Integer> res = new TreeMap<>();

        for (String word : list)
            for (char c : word.toCharArray())
                if (res.containsKey(c))
                    res.put(c, res.get(c) + 1);
                else
                    res.put(c, 1);

        return res;
    }

    public Map<String, Integer> getWords()
    //- вернуть Map, который содержит все
//        найденные слова и количество раз, которое каждое слово встретилось. Знаки препинания,
//        такие как “.,!? @” и др являются разделителями.
    {
        Map<String, Integer> res = new TreeMap<>();

        for (String word : list)
            if (res.containsKey(word))
                res.put(word, res.get(word) + 1);
            else
                res.put(word, 1);

        return res;
    }

    public static void main(String[] args) throws Exception
    {
        UsageFrequency usageFrequency = new UsageFrequency();
        //usageFrequency.processFile("qyqy.txt");//"wiki.test.tokens");
        usageFrequency.processFile("wiki.test.tokens");

        System.out.println(usageFrequency.list.toString());
        System.out.println(usageFrequency.getLetters());
        System.out.println(usageFrequency.getWords());
    }
}
