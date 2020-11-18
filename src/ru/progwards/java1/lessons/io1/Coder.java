package ru.progwards.java1.lessons.io1;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Coder {
    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {
        try{
            FileInputStream reader = new FileInputStream(inFileName);
            FileOutputStream writer = new FileOutputStream(outFileName);
            byte[] arrayByte = reader.readAllBytes();
            for (int i = 0; i <  arrayByte.length; i++) {
                arrayByte[i] = (byte) code[arrayByte[i]];
            }
            writer.write(arrayByte);
            writer.close();
        } catch (IOException | ArrayIndexOutOfBoundsException e){
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
        char[] test1 = new char[256];
        for (int i = 255; i >= 0; i--) {
            test1[i] = (char) (Math.random()*127);
        }

        codeFile("forRead.txt", "forWrite.txt", test1, "logfile.txt");
    }
}
