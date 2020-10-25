package ru.progwards.java1.lessons.bigints;

public class ByteInteger extends AbsInteger {
    byte byteNum;
    ByteInteger(byte byteNum){
        this.byteNum = byteNum;
    }

    @Override
    public String toString() {
        return String.valueOf(byteNum);
    }
    @Override
    public int getValue(){
        return  this.byteNum;
    }
}
