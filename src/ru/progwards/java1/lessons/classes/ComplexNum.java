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
    // вычитание комплексных чисел по формуле:
    // this - num = (this.a - num.a) + (this.b - num.b)i
    public ComplexNum sub(ComplexNum num){
        ComplexNum result = new ComplexNum(this.a - num.a, this.b - num.b);
        return result;
    }
    // умножение комплексных чисел по формуле:
    // this * num = (this.a * num.a - this.b * num.b) + (this.b * num.a + this.a * num.b)i
    public ComplexNum mul(ComplexNum num){
        ComplexNum result = new ComplexNum(this.a * num.a - this.b * num.b, this.b * num.a + this.a * num.b);
        return result;
    }
    // деление комплексных чисел по формуле:
    // this / num = (this.a * num.a + this.b * num.b) / (num.a * num.a + num.b * num.b) +
    // ((this.b * num.a - this.b * num.b) / (num.a * num.a + num.b * num.b))i
    public ComplexNum div(ComplexNum num){
        ComplexNum result = new ComplexNum((this.a * num.a + this.b * num.b) / (num.a * num.a + num.b * num.b), (this.b * num.a - this.b * num.b) / (num.a * num.a + num.b * num.b));
        return  result;
    }

    public static void main(String[] args) {
        ComplexNum z1 = new ComplexNum(5, 4);
        ComplexNum z2 = new ComplexNum(8, 2);
        ComplexNum z3 = new ComplexNum(5, 4);
        ComplexNum z4 = new ComplexNum(8, 2);
        ComplexNum z5 = new ComplexNum(5, 4);
        ComplexNum z6 = new ComplexNum(8, 2);
        ComplexNum z7 = new ComplexNum(5, 4);
        ComplexNum z8 = new ComplexNum(8, 2);
        ComplexNum result_add = z1.add(z2);
        ComplexNum result_sub = z3.sub(z4);
        ComplexNum result_mul = z5.mul(z6);
        ComplexNum result_div = z7.div(z8);
        System.out.println(result_add);
        System.out.println(result_sub);
        System.out.println(result_mul);
        System.out.println(result_div);
    }
}
