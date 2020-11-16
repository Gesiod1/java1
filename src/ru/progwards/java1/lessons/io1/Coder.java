package ru.progwards.java1.lessons.io1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Coder {
    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {
        try{
            FileReader reader = new FileReader(inFileName);
            Scanner scanner = new Scanner(reader);
            FileWriter writer = new FileWriter(outFileName);
            while (scanner.hasNextLine()){
                String nextLine = scanner.nextLine();
                String charNextLine = new String();
                byte[] arrayNextLine = new byte [nextLine.length()];
                for (int i = 0; i < nextLine.length(); i++) {
                    arrayNextLine[i] = (byte) nextLine.charAt(i);
                }
                for (int i = 0; i < nextLine.length(); i++) {
                    arrayNextLine[i] = (byte) code[arrayNextLine[i]];
                    charNextLine += (char) arrayNextLine[i];
                }
                writer.write(charNextLine + "\n");
            }
            writer.close();
        } catch (IOException e){
            try {
                FileWriter logWrite = new FileWriter(logName);
                logWrite.write(e.getMessage());
                logWrite.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws IOException {
        char[] test1 = new char[255];
        for (int i = 254; i > 0; i--) {
            test1[i] = (char) (Math.random()*127)
            ;
        }

        codeFile("forRead.txt", "forWrite.txt", test1, "logfile.txt");
    }
}
