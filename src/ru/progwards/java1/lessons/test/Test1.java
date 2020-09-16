package ru.progwards.java1.lessons.test;

public class Test1 {
    final static double CONST_MIN = 1.61703;
    final static double CONST_MAX = 1.61903;
    public static boolean isGoldenTriangle(int a, int b, int c) {
        /* создаем переменные для обозначения соотношения сторон,
         если треугольник равнобедренный */
        double ratio1 = ((double) a) / c;    // если А = В
        double ratio2 = ((double) c) / b;    // если А = С
        double ratio3 = ((double) b) / a;    // если В = С
        /* верхняя и нижняя границы */
        if ((a == b && a > c) || (a == c && a > b) || (b == c && b > a)) {
            // условие, если треугольник золотой
            return (CONST_MIN <= ratio1 && ratio1 <= CONST_MAX) ||
                    (CONST_MIN <= ratio2 && ratio2 <= CONST_MAX) ||
                    (CONST_MIN <= ratio3 && ratio3 <= CONST_MAX);
        } else {
            return false;
        }
    }
    public static int fiboNumber(int n){
        int n0 = 1;
        int n1 = 1;
        int n2 = 2;
        if (n == n0){
            n2 = n0;
            return n2;
        }
        if (n == n1){
            n2 = n1;
            return  n2;
        }
        for (int i = 3; i <= n; i++ ){
            n2 = n1 + n0;
            n0 = n1;
            n1 = n2;
        }
        return n2;
    }

    public static void main(String[] args) {
        System.out.println(isGoldenTriangle(55, 55, 89));
    }
}
