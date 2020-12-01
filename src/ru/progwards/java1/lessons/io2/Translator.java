package ru.progwards.java1.lessons.io2;

public class Translator {
    private String[] inLang;
    private  String[] outLang;
    Translator(String[] inLang, String[] outLang){
        this.inLang = inLang;
        this.outLang = outLang;
    }

    public String translate(String sentence){
        String[] sentenceArray = sentence.split(" ");
        StringBuilder stringBuilder = new StringBuilder(); // строка для записи слов
        StringBuilder charStr = new StringBuilder(); // строка для записи символов
        StringBuilder upperCase = new StringBuilder();
        for (int i = 0; i < sentenceArray.length; i++) {
            //проверить наличие символов в конце слова из массива sentenceArray,
            // и если есть, то записываем его в строку charStr
            // получаем слова без символов - делаем replace символа на ""
            for (Character c : sentenceArray[i].toCharArray()) {
                if (!Character.isAlphabetic(c)){
                    charStr.append(c);
                    String symbol = c.toString();
                    sentenceArray[i] = sentenceArray[i].replace(symbol, "");
                }
                if (!Character.isLowerCase(c)){
                    upperCase.append(c);
                    String upper = c.toString();
                    sentenceArray[i] = sentenceArray[i].replace(upper, upper.toLowerCase());
                }
            }

            for (int j = 0; j < inLang.length; j++) { // проверяем слово из sentence на наличие его в массиве inLang
                if (sentenceArray[i].equals(inLang[j])){ // если есть
                    if (upperCase != null){
                        char[] forUpperCase = outLang[j].toCharArray();
                        String firstLetter = Character.toString(forUpperCase[0]);
                        firstLetter = firstLetter.toUpperCase();
                        char[] firstLetterArray = firstLetter.toCharArray();
                        outLang[j] = outLang[j].replace(forUpperCase[0], firstLetterArray[0]);
                    }
                    stringBuilder.append(outLang[j]); // берем это слово из массива outLang

                    stringBuilder.append(charStr); // добавляем символ
                    if(i == inLang.length - 1){
                        break;
                    }
                    stringBuilder.append(' ');
                }
            }
            charStr.setLength(0); // очищаем строку с символами для новой итерации
        }
        String result = stringBuilder.toString();
        return  result;
    }

    public static void main(String[] args) {
        String[] rus = {"Я", "люблю", "свою", "работу"};
        String[] eng = {"I", "like", "my", "job"};
        String fuckOff = "Свою, Работу!!!";
        Translator translator = new Translator(rus, eng);
        System.out.println(translator.translate(fuckOff));
    }
}
