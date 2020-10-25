package ru.progwards.java1.lessons.bigints;

public class ShortInteger extends AbsInteger{
    short shortNum;
    ShortInteger(short shortNum){
        this.shortNum = shortNum;
    }

    @Override
    public String toString() {
        return String.valueOf(shortNum);
    }
    @Override
    public int getValue(){
        return  this.shortNum;
    }
}
