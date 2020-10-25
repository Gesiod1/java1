package ru.progwards.java1.lessons.bigints;

public class IntInteger extends AbsInteger {
    int integerNum;
    IntInteger (int integerNum){
        this.integerNum = integerNum;
    }

    @Override
    public String toString() {
        return String.valueOf(integerNum);
    }
    @Override
    public int getValue(){
        return  this.integerNum;
    }
}
