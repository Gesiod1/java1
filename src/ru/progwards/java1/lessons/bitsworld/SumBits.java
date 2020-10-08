package ru.progwards.java1.lessons.bitsworld;

public class SumBits {

    // суммирует все биты параметра value
    public static int sumBits(byte value){
        int result = 0;
        int valueInt = value & 0b00000000_00000000_00000000_11111111;

        while (valueInt > 0){
            int quantity = valueInt & 0b1; //записывает бит для сложения
            result += quantity;
            valueInt >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(sumBits((byte) 0b10000000));
    }
}
