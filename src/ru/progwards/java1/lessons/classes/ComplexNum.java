package ru.progwards.java1.lessons.classes;

public class ComplexNum {
    int a; // действительная часть
    int b; // мнимая часть
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
    // this + num = (this.a + num.a) + (this.b + num.b)i
    public ComplexNum add(ComplexNum num){
        // есть комплексное число this И num
        ComplexNum result = new ComplexNum(this.a + num.a, this.b + num.b);
        return result;
    }

    public static void main(String[] args) {
        ComplexNum z1 = new ComplexNum(34, 32);
        ComplexNum z2 = new ComplexNum(14, 21);
        ComplexNum result = z1.add(z2);
        System.out.println(result);
    }

}
