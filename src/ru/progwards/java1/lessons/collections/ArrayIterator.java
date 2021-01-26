package ru.progwards.java1.lessons.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

//Сделать итератор по одномерному массиву, реализовать методы hasNext() и next()
public class ArrayIterator<T> implements Iterator<T>  {
    private T[] array;
    private  Integer index = 0;

    ArrayIterator(T[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
         if (this.array.length == 0){
             return false;
         }
         return index != this.array.length - 1;
    }

    @Override
    public T next() throws NoSuchElementException{
        if (this.array.length <= 0){
            throw new NoSuchElementException("No more elements in array!");
        }
        return  index < array.length ? array[index++] : null;
    }

}
