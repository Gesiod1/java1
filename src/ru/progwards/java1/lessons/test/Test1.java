package ru.progwards.java1.lessons.test;

public class Test1 {
    static long factorial(long n){
        long result = 1;
        for (long l = 1; l <= n; l++){
            result *= l;
            if (n == 0){
                result = 1;
            }
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(factorial(5));
        }
    }

