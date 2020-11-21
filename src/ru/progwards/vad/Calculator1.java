package ru.progwards.vad;

import java.util.Scanner;

public class Calculator1 {
    public static double add(int num1, int num2){
        return num1 + num2;
    }
    public static double sub(int num1, int num2){
        return num1 - num2;
    }
    public static double multiply(int num1, int num2){
        return num1 * num2;
    }
    public static double division(int num1, int num2){
        return num1 / num2;
    }
    public static void example(){
        String str = "";
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                str = scanner.nextLine();
                int num1 = scanner.nextInt();
                int num2 = scanner.nextInt();
                if (str.contains("+"))
                    System.out.println(add(num1, num2));
                else if (str.contains("-"))
                    System.out.println(sub(num1, num2));
                else if (str.contains("*"))
                    System.out.println(multiply(num1, num2));
                else if (str.contains("/"))
                    System.out.println(division(num1, num2));
                else break;
            }
        }
    }

    public static void main(String[] args) {
        example();
    }
}
