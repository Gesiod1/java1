package ru.progwards.java1.lessons.io1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharFilter {
    public static void filterFile(String inFileName, String outFileName, String filter) throws IOException {
//        try {
//            FileReader reader = new FileReader(inFileName);
//            Scanner scanner = new Scanner(reader);
//            char[] filterToChar = filter.toCharArray();
//            while (scanner.hasNextLine()){
//                String strNextLine = scanner.nextLine();
//                for (int i = 0; i < filterToChar.length; i++) {
//                    strNextLine = strNextLine.replace(String.valueOf(filterToChar[i]), "");
//                }
//                FileWriter writer = new FileWriter(outFileName);
//                writer.write(strNextLine);
//                writer.close();
//            }
//        }catch (FileNotFoundException e){
//            e.getMessage();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            FileReader reader = new FileReader(inFileName);
            FileWriter writer = new FileWriter(outFileName);
            Scanner scanner = new Scanner(reader);
            while (true) {
                String nextLine = scanner.nextLine();
                String newLine = "";
                for (Integer i = 0; i < nextLine.length(); i++) {
                    Boolean toFilter = false;
                    for (Integer j = 0; j < filter.length(); j++) {
                        if (nextLine.charAt(i) == filter.charAt(j)) {
                            toFilter = true;
                        }
                    }
                    newLine += toFilter ? "" : nextLine.charAt(i);
                }
                writer.write(newLine);
                if (!scanner.hasNextLine()) break;
            }
            writer.close();
        } catch (FileNotFoundException exception) {
            throw new IOException(exception.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        String filter1 = "be";
        filterFile("C:/Users/Марина/IdeaProjects/HelloWorld/src/forRead.txt", "C:/Users/Марина/IdeaProjects/HelloWorld/src/forWrite.txt", filter1);
    }
}
