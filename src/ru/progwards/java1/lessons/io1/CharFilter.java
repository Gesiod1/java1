package ru.progwards.java1.lessons.io1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharFilter {
    public static void filterFile(String inFileName, String outFileName, String filter) throws FileNotFoundException {
        try {
            FileReader reader = new FileReader(inFileName);
            Scanner scanner = new Scanner(reader);
            char[] filterToChar = filter.toCharArray();
            while (scanner.hasNextLine()){
                String strNextLine = scanner.nextLine();
                for (int i = 0; i < filterToChar.length; i++) {
                    strNextLine = strNextLine.replaceAll(String.valueOf(filterToChar[i]), "");
                }
                FileWriter writer = new FileWriter(outFileName);
                writer.write(strNextLine);
                writer.close();
            }
        }catch (FileNotFoundException e){
            e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        String filter1 = "be";
        filterFile("forRead", "forWrite", filter1);
    }
}
