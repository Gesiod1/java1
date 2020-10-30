package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;
import java.util.Arrays;

public class ArrayInteger {
private int n;
private byte[] digits;

    ArrayInteger(int n){
        this.n = n;
        digits = new byte[n];
    }

    void fromInt(BigInteger value){
        BigInteger remainder = new BigInteger("0"); // остаток
        BigInteger tempArray = new BigInteger("0"); // временная переменная для записи числа после деления на 10
        for (int i = 0; (i < this.n) && (value.compareTo(BigInteger.ZERO) >= 0); i++) {
            byte[] copyByteArray = Arrays.copyOf(digits, digits.length);
            tempArray = value;
            remainder = value.mod(BigInteger.TEN);
            copyByteArray[i] = remainder.byteValue();
            digits = copyByteArray;
            value = tempArray.divide(BigInteger.TEN);
        }
    }
    BigInteger toInt(){
        BigInteger result = BigInteger.ZERO;
        BigInteger p = BigInteger.ONE;

        for (int i = 0; i < digits.length; i++) {
            result = result.add(BigInteger.valueOf(digits[i]));
            p = p.multiply(BigInteger.TEN);
        }
        return result;
    }
    public static void main(String[] args) {
        ArrayInteger arr1 = new ArrayInteger(2);
        arr1.fromInt(new BigInteger("123"));
    }

//    static  byte[] fillArray (int n){
//        //записываем цифры числа в элемнты массива
//        byte[] byteArray = {};
//        byte remainder = 0; // остаток
//        int tempArray = 0; // временная переменная для записи числа после деления на 10
//        int forLength = String.valueOf(n).length();
//        for (int i = 0; i < forLength; i++) {
//            byte[] copyByteArray = Arrays.copyOf(byteArray, byteArray.length + 1);
//            tempArray = n;
//            remainder = (byte) (n % 10);
//            copyByteArray[i] = remainder;
//            byteArray = copyByteArray;
//            n = tempArray / 10;
//        }
//        //разворачиваем элемнты массива в нужном порядке
//        int size = byteArray.length;
//        for (int i = 0; i < size / 2; i++) {
//            byte temp = byteArray[i];
//            byteArray[i] = byteArray[size - 1 - i];
//            byteArray[size - 1 - i] = temp;
//        }
//        return byteArray;

}
