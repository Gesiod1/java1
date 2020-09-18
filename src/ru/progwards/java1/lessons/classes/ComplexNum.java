package ru.progwards.java1.lessons.classes;

public class ComplexNum {
    int a;
    int b;
    public ComplexNum(int a, int b){
        this.a = a;
        this.b = b;
    }
    // приведение к строке, выдать в формате a+bi,
    // например, при a=1 и b=56 должно быть выдано 1+56i
    @Override
    public String toString(){
        return a + "+" + b + "i";
    }
    // сложение комплексных чисел по формуле:
    // (a + bi) + (c + di) = (a + c) + (b + d)i

}
