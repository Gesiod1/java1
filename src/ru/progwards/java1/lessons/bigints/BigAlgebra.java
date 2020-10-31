package ru.progwards.java1.lessons.bigints;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigAlgebra {
    static BigDecimal fastPow(BigDecimal num, int pow){
        BigDecimal result = new BigDecimal(1);
        for (int i = 0; i < pow; i++){
            result = result.multiply(num);
        } return result;
    }
    static BigInteger fibonacci(int n){
        BigInteger f0 = BigInteger.valueOf(0);
        BigInteger f1 = BigInteger.valueOf(1);
        BigInteger tmp = BigInteger.valueOf(0);
        if (f0.compareTo(BigInteger.valueOf(n)) == 0){
            return f0;
        }
        for (int i = 1; i < n; i++) {
            tmp = f1;
            f1 = f1.add(f0);
            f0 = tmp;
        }
        return f1;
    }

    public static void main(String[] args) {
        BigAlgebra bigAlgebra = new BigAlgebra();
        System.out.println(bigAlgebra.fastPow(new BigDecimal("4"), 3));
        System.out.println(bigAlgebra.fibonacci(7));
        System.out.println(fastPow(new BigDecimal("5"), 4));
    }
}
