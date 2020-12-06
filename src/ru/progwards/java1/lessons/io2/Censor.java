package ru.progwards.java1.lessons.io2;

import java.io.*;
import java.util.Scanner;

public class Censor {
    private String[] obscene;
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

    public static void censorFile(String inoutFileName, String[] obscene) throws IOException, CensorException {
        try {
            FileReader reader = new FileReader(inoutFileName);
            Scanner scanner = new Scanner(reader);
            StringBuilder stringBuilder = new StringBuilder(); // строка для записи слов
            while (scanner.hasNextLine()){
                String nextLine = scanner.nextLine();
                stringBuilder.append(nextLine);
            }
            String allText = stringBuilder.toString();
            String[] allTextArray = allText.split(" ");
            StringBuilder word = new StringBuilder();//
            StringBuilder charStr = new StringBuilder(); // строка для записи символов
            for (int i = 0; i < allTextArray.length; i++) {
                String bufferWord = allTextArray[i];
                //проверить наличие символов в конце слова из массива allTextArray,
                // и если есть, то записываем его в строку charStr
                // получаем слова без символов - делаем replace символа на ""
                for (Character c : allTextArray[i].toCharArray()) {
                    if (!Character.isAlphabetic(c)) {
                        charStr.append(c);
                        String symbol = c.toString();
                        allTextArray[i] = allTextArray[i].replace(symbol, "");
                    }
                }

                boolean checkObsence = false; // для проверки, было ли слово в obsence
                for (int j = 0; j < obscene.length; j++) { // проверяем слово из файла на наличие его в массиве obsence
                    if (allTextArray[i].equals(obscene[j])){ // если есть
                        String stars = "";
                        for (int k = 0; k < allTextArray[i].length(); k++) {
                            stars += "*";
                        }
                        word.append(stars);
                        word.append(charStr); // добавляем символ
                        if(i == allTextArray.length - 1){ // если конец текста
                            break;
                        }
                        word.append(' ');
                        checkObsence = true;
                    }
                }
                if (!checkObsence){ // если слово не содержится в obsence
                    word.append(bufferWord);
                    if(i == allTextArray.length - 1){
                        break;
                    }
                    word.append(' ');
                }
                charStr.setLength(0); // очищаем строку с символами для новой итерации
            }
            reader.close();
            FileWriter fileWriter = new FileWriter(inoutFileName);
            String textStr = word.toString();
            fileWriter.write(textStr);
            fileWriter.close();

        } catch (Exception e){
            throw new CensorException(e.getMessage(), inoutFileName);
        }
    }

    public static void main(String[] args) throws IOException, CensorException {
        String[] censor = {"дней", "суббота", "рационально"};
        try {
            censorFile("forRead.txt", censor);
        } catch (CensorException e) {
            System.out.println(e.toString());
        }
        System.out.println();
    }
}
