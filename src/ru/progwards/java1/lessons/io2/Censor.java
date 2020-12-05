package ru.progwards.java1.lessons.io2;

import java.io.*;
import java.util.Scanner;

public class Censor {
    private String[] obscene;
     class CensorException extends Exception{
         private String message;
         CensorException(String message){
             this.message = message;
         }

         @Override
         public String toString() {
             return "CensorException{" +
                     "message='" + message + '\'' +
                     '}';
         }
     };

    public static void censorFile(String inoutFileName, String[] obscene) throws IOException {
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
                    word.append(allTextArray[i]);
                    word.append(charStr); // добавляем символ
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

        } catch (IOException e){
            //throw new CensorException(e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        String[] censor = {"дней", "суббота", "рационально"};
        censorFile("forRead.txt", censor);
        System.out.println();
    }
}
