package ru.progwards.java1.lessons.queues;

import java.util.Comparator;
import java.util.PriorityQueue;

public class OrderQueue {

    //2.7 Создать метод, public void add(Order order),
    // размещающий заказы в очередь с приоритетом, разбивая их по 3-м классам
    //3 - заказы до 10000 руб включительно
    //2 - заказы от 10000 до 20000 руб включительно
    //1 - заказы от 20000 руб
    private final static double SUM_FOR_FIRST_QUEUE = 20000;
    private final static double SUM_FOR_SECOND_QUEUE = 10000;

    Comparator<Order> comparatorNumSort = new Comparator<Order>() {
        @Override
        public int compare(Order o1, Order o2) {
            return Integer.compare(o1.getNum(), o2.getNum());
        }
    };
    // компаратор для очереди классов по сумме заказов

    PriorityQueue<Order> queForThirdClass = new PriorityQueue<>(comparatorNumSort);  // очередь для заказов до 10000 руб включительно
    PriorityQueue<Order> queForSecondClass = new PriorityQueue<>(comparatorNumSort); // очередь для заказов от 10000 до 20000 руб включительно
    PriorityQueue<Order> queForFirstClass = new PriorityQueue<>(comparatorNumSort); // очередь для заказов от 20000 руб

    public void add(Order order){
        // компаратор для размещения в очередди заказов внутри каждого класса в порядке нумерации

        if (order.getSum() <= SUM_FOR_SECOND_QUEUE){
            queForThirdClass.offer(order);
        }
        if (SUM_FOR_SECOND_QUEUE < order.getSum() && order.getSum() <= SUM_FOR_FIRST_QUEUE){
            queForSecondClass.offer(order);
        }
        if (order.getSum() > SUM_FOR_FIRST_QUEUE){
            queForFirstClass.offer(order);
        }
    }
    public Order get(){
        if (!queForFirstClass.isEmpty()){
            return queForFirstClass.poll();
        }
        if (!queForSecondClass.isEmpty()){
            return queForSecondClass.poll();
        }
        if (!queForThirdClass.isEmpty()){
            return queForThirdClass.poll();
        }
        return null;
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
        OrderQueue orderQueue = new OrderQueue();
        orderQueue.add(test1);
        orderQueue.add(test5);
        orderQueue.add(test3);
        orderQueue.add(test4);
        orderQueue.add(test2);
        orderQueue.add(test6);
        orderQueue.add(test8);
        orderQueue.add(test7);
        System.out.println(orderQueue.get().getSum());
        System.out.println(orderQueue.get().getSum());
        System.out.println(orderQueue.get().getSum());
        System.out.println(orderQueue.get().getSum());
        System.out.println(orderQueue.get().getSum());
        System.out.println(orderQueue.get().getSum());
        System.out.println(orderQueue.get().getSum());
        System.out.println(orderQueue.get().getSum());

    }
}
