package ru.progwards.java1.lessons.basics;

public class ReverseDigits {
    public static int reverseDigits(int number){
        int ones = number % 10;
        int tens = ((number - ones) / 10) % 10;
        int hundreds = (number - (number % 100)) / 100;
        String ones1 = Integer.toString(ones);
        String tens1 = Integer.toString(tens);
        String hundreds1 = Integer.toString(hundreds);
        String str = ones1 + tens1 + hundreds1;
        int alls = Integer.valueOf(str);
        System.out.println(alls);
        return alls;
    }
    public static void main(String[] args) {
        reverseDigits(841);
    }
}
