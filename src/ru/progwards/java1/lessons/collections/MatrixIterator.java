package ru.progwards.java1.lessons.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator<T> implements Iterator<T> {
    private T[][] array;
    private Integer index = 0;
    private Integer indexNested = 0;
    private Integer nestedLenght = 0;

    MatrixIterator(T[][] array) {
        this.array =  array;
        updateNextArrayLengt();
    }
    private void updateNextArrayLengt(){
        if (this.nestedLenght == 0 && index < this.array.length){
            this.nestedLenght = this.array[index].length;
        }
    }

    @Override
    public boolean hasNext() {
        if (array.length == 0 || (index == array.length - 1 && indexNested == array[index].length)){
            return false;
        }
        return index != this.array.length;
    }

    @Override
    public T next() throws NoSuchElementException{
        if (array.length <= 0){
            throw new NoSuchElementException("No more elements in array!");
        }
        if (indexNested.equals(nestedLenght)){
            index++;
            indexNested = nestedLenght = 0;
        }
        updateNextArrayLengt();
        return  index < array.length ? array[index][indexNested++] : null;
    }

    public static void main(String[] args) {
        String [][] test = {{"a", "b"}, {"d", "d", "c"}, {"a", "z"}};
        MatrixIterator<String> matrixIterator = new MatrixIterator<String>(test);
        while (matrixIterator.hasNext()){
            System.out.println(matrixIterator.next());
        }
    }
}
