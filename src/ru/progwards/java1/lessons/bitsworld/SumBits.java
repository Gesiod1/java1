package ru.progwards.java1.lessons.bitsworld;

public class SumBits {

    // суммирует все биты параметра value
    public static int sumBits(byte value){
        int result = 0;

        while (value > 0){
            int quantity = value & 0b1; //записывает бит для сложения
            result += quantity;
            value >>>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(sumBits((byte) 0b1111100));
    }
}
