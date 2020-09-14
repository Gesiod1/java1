package ru.progwards.java1.lessons.basics;

public class ReverseDigits {
    public static String reverseDigits(int number){
        int ones = number % 10;
        int tens = ((number - ones) / 10) % 10;
        int hundreds = (number - (number % 100)) / 100;
        String ones1 = Integer.toString(ones);
        String tens1 = Integer.toString(tens);
        String hundreds1 = Integer.toString(hundreds);

        System.out.println(ones1 + tens1 + hundreds1);
        return ones1 + tens1 + hundreds1;
    }
    public static void main(String[] args) {
        reverseDigits(841);
    }
}
