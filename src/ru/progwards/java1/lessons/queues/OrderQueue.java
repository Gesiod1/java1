package ru.progwards.java1.lessons.queues;

import java.util.Comparator;
import java.util.PriorityQueue;

public class OrderQueue {

    private final static double SUM_FOR_FIRST_QUEUE = 20000;
    private final static double SUM_FOR_SECOND_QUEUE = 10000;

    //2.7 Создать метод, public void add(Order order),
    // размещающий заказы в очередь с приоритетом, разбивая их по 3-м

    // компаратор для размещения в очередди заказов внутри каждого класса в порядке нумерации
    Comparator<Order> comparatorNumSort = new Comparator<Order>() {
        @Override
        public int compare(Order o1, Order o2) {
            return Integer.compare(o1.getNum(), o2.getNum());
        }
    };
    // компаратор для очереди классов по сумме заказов
    Comparator<Order> comparatorSumSort = new Comparator<Order>() {
        @Override
        public int compare(Order o1, Order o2) {
            return Double.compare(o1.getSum(), o2.getSum());
        }
    };
    PriorityQueue<Order> queForThirdClass = new PriorityQueue<>(comparatorNumSort);  // очередь для заказов до 10000 руб включительно
    PriorityQueue<Order> queForSecondClass = new PriorityQueue<>(comparatorNumSort); // очередь для заказов от 10000 до 20000 руб включительно
    PriorityQueue<Order> queForFirstClass = new PriorityQueue<>(comparatorNumSort); // очередь для заказов от 20000 руб
    PriorityQueue<Order> queForAllOrders = new PriorityQueue<>(comparatorSumSort); // очередь для всех заказов
    public void add(Order order){

        if (order.getSum() <= SUM_FOR_SECOND_QUEUE){
            queForThirdClass.offer(order);
        }
        if (SUM_FOR_SECOND_QUEUE < order.getSum() && order.getSum() <= SUM_FOR_FIRST_QUEUE){
            queForSecondClass.offer(order);
        }
        if (order.getSum() > SUM_FOR_FIRST_QUEUE){
            queForFirstClass.offer(order);
        }
        queForAllOrders.offer(order);
    }

    public static void main(String[] args) {
        OrderQueue orderQueue = new OrderQueue();


    }
}
