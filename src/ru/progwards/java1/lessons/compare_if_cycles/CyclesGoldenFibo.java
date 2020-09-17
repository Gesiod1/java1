package ru.progwards.java1.lessons.compare_if_cycles;

public class CyclesGoldenFibo {
    final static double CONST_MIN = 1.61703;
    final static double CONST_MAX = 1.61903;
    public static boolean containsDigit(int number, int digit){
        int remainderOfDivision;
        if (number >= 1){
            while (number >= 1){
                remainderOfDivision = number % 10;
                if (remainderOfDivision == digit){
                    return true;
                }
                number/= 10;
            }
        } else {
            if (number == digit && digit == 0){
                return true;
            }
        }
        return false;
    }
    public static int fiboNumber(int n){
        int f0 = 0;
        int f1 = 1;
        int tmp;
        if (n == f0){
            return f0;
        }
        for (int i = 1; i < n; i++) {
            tmp = f1;
            f1 = f1 + f0;
            f0 = tmp;
        }
        return f1;
    }
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

    public static void main(String[] args) {
        System.out.print(fiboNumber(3));
        /* что требуется в 3.3 понимаю, но не знаю как реализовать
         */
    }

}
