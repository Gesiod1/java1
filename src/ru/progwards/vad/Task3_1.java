package ru.progwards.vad;

import java.sql.SQLOutput;

public class Task3_1 {
    static double fractional(double num){
       int b = (int) num;
       double z = num - b;
        System.out.println(z);
        return z;
    }

    public static void main(String[] args) {
        fractional(832.6245);



    }
}
