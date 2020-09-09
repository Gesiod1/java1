package ru.progwards.vad;

public class Task2 {
        public static void printJava() {
            String good;
            String learn;
            String space;
            good = "Хорошо идут дела";
            learn = "Изучаю Java я!";
            space = " ";
            System.out.println(good);
            System.out.println(learn);
            System.out.println(good + space + learn);
            System.out.println(learn + space + good);
        }

        public static int subtraction(int x, int y){
            int z = x - y;
            System.out.print("Вызвана функция subtraction() с параметрами x = ");
            System.out.print(x);
            System.out.print(", y = ");
            System.out.println(y);
            return z;
        }
        public static int addition (int x, int y) {
            int z = x + y;
            System.out.print("Вызвана функция addition() с параметрами x = ");
            System.out.print(x);
            System.out.print(", y = ");
            System.out.println(y);
            return z;
        }
        public static int multiplication (int x, int y){
            int z = x * y;
            System.out.print("Вызвана функция multiplication() с параметрами x = ");
            System.out.print(x);
            System.out.print(", y = ");
            System.out.println(y);
            return z;
        }
        public static void calculation (){
            int a;
            int b;
            int c;
            a = 34;
            b = 55;
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            c = addition(a, b);
            System.out.println("a + b = " + c);
            c = subtraction(a, b);
            System.out.println("a - b = " + c);
            c = multiplication(a, b);
            System.out.println("a * b = " + c);

        }

        public static void main(String[] args) {

            printJava();
            subtraction(45, 12);
            subtraction(23, 55);
            addition(128, 787);
            addition(528, 387);
            multiplication(124, 87);
            multiplication(1528, 3);
        }

}
