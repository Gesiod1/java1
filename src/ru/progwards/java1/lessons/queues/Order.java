package ru.progwards.java1.lessons.queues;

import java.util.Iterator;

public class Order{
    private double sum;  // сумма заказа
    private static int num = 0;  // номер заказа
    private int publicNum = 0;

    //для номера заказа создать систему автонумерации, начиная с 1
    public Order(double sum){
        this.sum = sum;
        num++;
        publicNum = num;
    }

    public double getSum() {
        return sum;
    }

    public int getNum() {
        return publicNum;
    }

    public static void main(String[] args) {
        Order test1 = new Order(1200);
        Order test2= new Order(2132321);
        Order test3 = new Order(334);
        Order test4 = new Order(335);
        Order test5 = new Order(12234);
        Order test6 = new Order(15699);
        Order test7= new Order(22321);
        Order test8= new Order(15321);
        System.out.println(test1.getNum());
        System.out.println(test2.getNum());
        System.out.println(test3.getNum());
        System.out.println(test4.getNum());
        System.out.println(test5.getNum());
        System.out.println(test6.getNum());
    }


}
