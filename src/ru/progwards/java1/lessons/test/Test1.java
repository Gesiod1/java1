package ru.progwards.java1.lessons.test;

public class Test1 {
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
        System.out.println(isGoldenTriangle(13, 21, 21));
    }
}
