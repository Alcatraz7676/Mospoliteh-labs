package com.company.task8;

import java.util.ArrayList;
import java.util.Iterator;

public class Set implements Iterable<Integer> {
    private ArrayList<Integer> array;

    public Set(ArrayList<Integer> array) {
        this.array = new ArrayList<Integer>();
        boolean newValue = true;
        for (Integer newElement : array) {
            for (Integer element : this.array) {
                if (element.equals(newElement)) {
                    newValue = false;
                    break;
                }
            }
            if (newValue) {
                this.array.add(newElement);
            } else
                newValue = true;
        }
    }

    public Set(int size) {
        array = new ArrayList<Integer>(size);
    }

    public int size() {
        return array.size();
    }

    public void print() {
        System.out.println(array);
    }

    public void add(Set set) {
        for (Integer element : set) {
            if (!contains(element))
                array.add(element);
        }
    }

    public void add(Integer item) {
        for (Integer element : array) {
            if (element.equals(item))
                return;
        }
        array.add(item);
    }

    // Этот метод не проверяет, хранит ли массив такое значение (Использовать с осторожностью)
    public void addQuick(Integer item) {
        array.add(item);
    }

    public void removeByValue(Integer item) {
        array.remove(item);
    }

    public boolean contains(Integer item) {
        for (Integer element : array) {
            if (element.equals(item))
                return true;
        }
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator<Integer> {

        private int index = 0;

        public boolean hasNext() {
            return index < array.size();
        }

        @SuppressWarnings("unchecked")
        public Integer next() {
            return array.get(index++);
        }

        public void remove() {
            throw new UnsupportedOperationException("not supported yet");
        }
    }
}
