package com.company.task7;

import java.util.Iterator;

public class Queue<E> implements Iterable<E> {
    private int maxSize;
    private Object[] array;
    private int front;
    private int end;
    private int size;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        array = new Object[maxSize];
        front = 0;
        end = -1;
        size = 0;
    }

    public void insert(E item) {
        if (end == maxSize-1)
            end = -1;
        array[++end] = item;
        size++;
    }

    @SuppressWarnings("unchecked")
    public E remove() {
        E temp = (E) array[front++];
        if (getSize() != 0) {
            if (front == maxSize)
                front = 0;
            size--;
        }
        return temp;
    }

    @SuppressWarnings("unchecked")
    public E peekFront() {
        return (E) array[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator<E> {

        private int index = 0;

        public boolean hasNext() {
            return index < array.length;
        }

        @SuppressWarnings("unchecked")
        public E next() {
            return (E) array[index++];
        }

        public void remove() {
            throw new UnsupportedOperationException("not supported yet");
        }
    }
}
