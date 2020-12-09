package ru.progwards.java1.lessons.io2;


import java.io.*;
import java.util.Scanner;

public class Censor {

     static class CensorException extends Exception{
         private String message;
         private String filename;

         public CensorException(String message, String filename) {
             this.message = message;
             this.filename = filename;
         }
         @Override
         public String toString(){
             return filename + ":" + message;
         }

     }

    private static StringBuilder getAllTextAsStringBuilder(Scanner scanner) {
        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            stringBuilder.append(nextLine + " ");
        }
        return  stringBuilder;
    }

    private static String[] convertStringToWordArray(StringBuilder stringBuilder) {
        String allText = stringBuilder.toString();
        return allText.split(" ");
    }

    private static String getWordWithoutEndingSymbols(String word) {
        Integer amountOfSymbols = 0;
        char [] wordSymbols = word.toCharArray();
        for (int i = wordSymbols.length - 1; i > 0; i--) {
            if (!Character.isAlphabetic(wordSymbols[i])) {
                amountOfSymbols++;
            } else {
                break;
            }
        }
        return word.substring(0, wordSymbols.length - amountOfSymbols);
    }
    private static String getEndingSymbols(String word){
         StringBuilder charsStr = new StringBuilder();
        char [] wordSymbols = word.toCharArray();
        for (int i = wordSymbols.length -1; i > 0;  i--) {
            if (!Character.isAlphabetic(wordSymbols[i])) {
                charsStr.append(wordSymbols[i]);
            } else {
                break;
            }
        }
         return charsStr.reverse().toString();
    }

    private static Boolean compareWithCensor(String[] obscene, String word) {
        for (int i = 0; i < obscene.length; i++) {
            if (obscene[i].toLowerCase().equals(word.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    private static String writeStars(String word) {
        String stars = "";
        for (int i = 0; i < word.length(); i++) {
            stars += "*";
        }
        return stars;
    }

    private static String wordsWithHyphen(String word, String[] obscene){
         String[] splitWords = word.split("-");
        for (int i = 0; i < splitWords.length; i++) {
            Boolean isCensored = compareWithCensor(obscene, splitWords[i]);
            if (isCensored) {
                splitWords[i] = writeStars(splitWords[i]);
            }
        }
        return String.join("-", splitWords);
    }

    public static void censorFile(String inoutFileName, String[] obscene) throws IOException, Censor.CensorException {
        try {
            FileReader reader = new FileReader(inoutFileName);
            Scanner scanner = new Scanner(reader);
            StringBuilder stringBuilder = getAllTextAsStringBuilder(scanner);
            String [] allWords = convertStringToWordArray(stringBuilder);
            for (int i = 0; i < allWords.length; i++) {
                String symbolsInWord = getEndingSymbols(allWords[i]);
                String originalWord = getWordWithoutEndingSymbols(allWords[i]);
                if (originalWord.contains("-")){
                    originalWord = wordsWithHyphen(originalWord, obscene);
                    allWords[i] = originalWord + symbolsInWord;
                }
                Boolean isCensored = compareWithCensor(obscene, originalWord);
                if (isCensored) {
                    allWords[i] = writeStars(originalWord);
                    allWords[i] += symbolsInWord;
                }
            }
            String finalText = String.join(" ", allWords);
            reader.close();
            FileWriter fileWriter = new FileWriter(inoutFileName);
            fileWriter.write(finalText);
            fileWriter.close();
        } catch (Exception e){
            throw new Censor.CensorException(e.getMessage(), inoutFileName);
        }
    }


    public static void main(String[] args) throws IOException, CensorException {
        String[] censor = {"two", "storey", "write", "day", "count"};
        try {
            censorFile("forRead.txt", censor);
        } catch (CensorException e) {
            System.out.println(e.toString());
        }
        System.out.println();
    }
}
