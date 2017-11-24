package com.company.task6;

import java.util.Iterator;

public class Stack<E> implements Iterable<E> {
    private int maxSize;
    private Object[] array;
    private int top;

    public Stack(int size) {
        maxSize = size;
        array = new Object[maxSize];
        // -1 значит отсутсвие элементов
        top = -1;
    }

    public void push(E element) {
        array[++top] = element;
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        return (E) array[top--];
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        return (E) array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize-1;
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
