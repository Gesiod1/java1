package ru.progwards.java1.lessons.interfaces;

//сохранение одного, последнего из рассчитанных значений
public class CalculateFibonacci {
    // приватная статическая переменная
    private  static CacheInfo lastFibo;

    public static class CacheInfo{
        //число, для которого рассчитываем Фибоначчи
        public int n;
        //результат расчета
        public int fibo;
    }

    // число Фибоначчи
    public static int fiboNumber(int n){
        if (lastFibo != null && lastFibo.n == n){
            return lastFibo.fibo;
        } else {
            int f0 = 0;
            int f1 = 1;
            int tmp;
            if (n == f0) {
                return f0;
            }
            for (int i = 1; i < n; i++) {
                tmp = f1;
                f1 += f0;
                f0 = tmp;
            }
            lastFibo.fibo = f1;
            lastFibo.n = n;
            return f1;
        }
    }
    // возвращает lastFibo
    public static CacheInfo getLastFibo() {
        return lastFibo;
    }
    // брасывает lastFibo в null
    public static void clearLastFibo(){
        lastFibo = null;
    }
    public static void main(String[] args) {
        System.out.println(fiboNumber(5));
    }
}

