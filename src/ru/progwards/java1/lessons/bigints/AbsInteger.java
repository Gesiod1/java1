package ru.progwards.java1.lessons.bigints;

public class AbsInteger {
    static AbsInteger add(AbsInteger num1, AbsInteger num2){
        int result = num1.getValue() + num2.getValue();
        if (result >= Byte.MIN_VALUE && result <= Byte.MAX_VALUE){
            return new ByteInteger((byte) result);
        } else  if (result >= Short.MIN_VALUE && result <= Short.MAX_VALUE){
            return new ShortInteger((short) result);
        } return new IntInteger(result);
    }
    public int getValue(){
        return 0;
    }

    public static void main(String[] args) {
        AbsInteger absNum1 = new ByteInteger((byte) 115);
        AbsInteger absNum2 = new ShortInteger((short) 258);
        AbsInteger absNum3 = new IntInteger(12345678);
        System.out.println(add(absNum2, absNum3));
    }
}
