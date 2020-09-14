package ru.progwards.java1.lessons.compare_if_cycles;

public class CyclesGoldenFibo {
    public static boolean containsDigit(int number, int digit){
        int remainderOfDivision; // остаток от деления на 10
        while (number >= 1){
            remainderOfDivision = number % 10;
            if (remainderOfDivision == digit){
                return true;
            }
            number/= 10;
        }
        return false;
    }
    public static int fiboNumber(int n){
        int n0 = 1;
        int n1 = 1;
        int n2 = 2;
        for(int i = 3; i <= n; i++){
            n2=n0+n1;
            n0=n1;
            n1=n2;
        }
        return n2;
    }
    public static boolean isGoldenTriangle(int a, int b, int c) {
        /* создаем переменные для обозначения соотношения сторон,
         если треугольник равнобедренный */
        double ratio1 = (double) a / c;    // если А = В
        double ratio2 = (double) c / b;    // если А = С
        double ratio3 = (double) b / a;    // если В = С
        /* верхняя и нижняя границы */
        double CONST_MIN = 1.61703;
        double CONST_MAX = 1.61905;
        if (a != b && b != c && a != c){ // условие, если треугольник не равнобедренный
            return  false;
        } else  { // проверяем, попадает ли соотношение сторон в наш диапазон
            return  (CONST_MIN <= ratio1 && ratio1 <= CONST_MAX)||
                    (CONST_MIN <= ratio2 && ratio2 <= CONST_MAX)||
                    (CONST_MIN <= ratio3 && ratio3 <= CONST_MAX);
        }
    }

    public static void main(String[] args) {
        System.out.println(isGoldenTriangle(9, 6, 6));
    }

}
