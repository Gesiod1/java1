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
    static long factorial(long n){
        int proizv = 1;
        int n0 = 0;
        if (n == n0){
            return n0;
        }
        for (int i = 1; i <= n; i++){
            proizv = proizv * i;
        }
        return proizv;
    }
    static String textGrade(int grade){
        String rating = null;
        if (grade == 0){
            rating = "не оценено";
        }
        if (0 < grade && grade <= 20){
            rating = "очень плохо";
        }
        if (20 < grade && grade <= 40){
            rating = "плохо";
        }
        if (40 < grade && grade <= 60){
            rating = "удовлетворительно";
        }
        if (60 < grade && grade <= 80){
            rating = "хорошо";
        }
        if (80 < grade && grade <= 100){
            rating = "отлично";
        }
        if (100 < grade){
            rating = "не определено";
        }
        return rating;
    }

    static int addAsStrings(int n1, int n2){
        String str1 = Integer.toString(n1);
        String str2 = Integer.toString(n2);
        Integer number = Integer.parseInt(str1+str2);
        return number;
    }
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

    public static void main(String[] args) {
        System.out.println(containsDigit(0, 0));
    }
}
