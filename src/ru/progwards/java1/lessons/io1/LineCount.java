package ru.progwards.java1.lessons.io1;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LineCount {
    public static int calcEmpty(String fileName) {
        try{
            FileReader reader = new FileReader(fileName);
            Scanner scanner = new Scanner(reader);
            int countEmptyLine = 0;
            while (true){
                String strNextLine = scanner.nextLine();
                if (strNextLine.length() == 0){
                    countEmptyLine++;
                }
                if (!scanner.hasNextLine()){
                    break;
                }
            }
            return countEmptyLine;
//            while (true){
//                countEmptyLine += scanner.hasNextLine() && scanner.nextLine().length() == 0 ? 1 : 0;
//                if (!scanner.hasNext()) return countEmptyLine;
//            }
        }

        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(calcEmpty("logfile.txt"));
    }
}
