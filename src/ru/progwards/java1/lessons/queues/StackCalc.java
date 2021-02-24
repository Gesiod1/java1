package ru.progwards.java1.lessons.queues;
//Стековый калькулятор (есть даже такой стековый язык программирования - Forth).
// Стек, это структура данных, работающая по принципу LIFO - last in first out
// (последний вошедший выходит первый), это противоположность привычной очереди
// FIFO - first in first out - первый вошедший выходит первый

//Реализовать class StackCalc, который содержит стек чисел с плавающей точкой (double).
// Выбрать наиболее удобную для этого коллекцию. Реализовать методы работы со стеком:

import java.util.ArrayDeque;
import java.util.Deque;

public class StackCalc {

    Deque<Double> deque = new ArrayDeque<>();

    //3.1 public void push(double value) - положить value на вершину стека
    public void push(double value){
        deque.offerLast(value);
    }
    //3.2 public double pop() - взять (убрать) значение с вершины стека
    public double pop(){
           return deque.poll();
    }
    //3.3 public void add() - сложить 2 верхних значения на стеке,
    // результат положить на стек. В итогу в стеке должно быть на один элемент меньше
    public void add(){
        double num1 = deque.pollLast();
        double num2 = deque.pollLast();
        deque.push(num1 + num2);
    }
    //3.4 public void sub() - вычесть верхнее значение на стеке, из следующего по глубине,
    // результат положить на стек. В итоге в стеке должно быть на один элемент меньше
    public void sub(){
        double num1 = deque.pollLast();
        double num2 = deque.pollLast();
        deque.push(num2 - num1);
    }
    //3.5 public void mul() - умножить 2 верхних значения на стеке,
    // результат положить на стек. В итогу в стеке должно быть на один элемент меньше
    public void mul(){
        double num1 = deque.pollLast();
        double num2 = deque.pollLast();
        deque.push(num2 * num1);
    }
    //3.6 public void div() - поделить на верхнее значение на стеке, следующее по глубине,
    // результат положить на стек. В итоге в стеке должно быть на один элемент меньше
    public void div(){
        double num1 = deque.pollLast();
        double num2 = deque.pollLast();
        deque.push(num2 / num1);
    }

    public static void main(String[] args) {
//        StackCalc stackCalc = new StackCalc();
//        Deque<StackCalc> doubleDeque = new ArrayDeque<>();
//        stackCalc.push(3.0);
//        stackCalc.push(1.0);
//        stackCalc.push(8.0);
//        stackCalc.add();
//        System.out.println(stackCalc.pop());
//        System.out.println(stackCalc.pop());
    }

}
