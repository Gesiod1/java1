package ru.progwards.java1.lessons.bitsworld;

public class CheckBit {
     //возвращает значение бита с порядковым номером bitNumber от параметра value
    public static int checkBit(byte value, int bitNumber){
        value >>= bitNumber;
        int bitValue = value & 0b1;
        return bitValue;
    }

    public static void main(String[] args) {
        System.out.println(checkBit((byte) 101100, 4));
    }
}
