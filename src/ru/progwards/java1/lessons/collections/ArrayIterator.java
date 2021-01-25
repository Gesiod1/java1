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
         return true;
    }

    @Override
    public T next() throws NoSuchElementException{
        if (array.length <=0){
            throw new NoSuchElementException("No more elements in array!");
        }
        if (index == 0){
            return array[index++];
        }
        if (index + 1 == array.length - 1){
            return array[++index];
        }
        return  index + 1 < array.length + 1 ? array[++index]: null;
    }

}
