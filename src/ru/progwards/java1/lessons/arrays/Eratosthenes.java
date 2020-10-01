package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class Eratosthenes {
    // свойства
    private boolean[] sieve;

    //метод
    public Eratosthenes(int N){
        sieve = new boolean [N + 1];
        Arrays.fill(sieve, true);
        sift();
    }

   private void sift(){
        for (int i = 2, n = sieve.length; i < n - 1; i++) {
            for (int j = 2, k ; (k = j*i) < n; j++) {
                sieve[k] = false;
            }
        }
    }

    public boolean isSimple(int n){
        return sieve[n];
    }

    public static void main(String[] args) {
        Eratosthenes eratosthenes_1 = new Eratosthenes(5);
        System.out.println(Arrays.toString(eratosthenes_1.sieve));
    }
}
