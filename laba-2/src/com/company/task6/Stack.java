package com.company.task6;

import java.util.Iterator;

// Стек - это структура данных, которая возвращает последний введенный элемент (Примером стека служит стопка бумаг)
// Данный класс использует дженерики(generic types). Благодаря им можно создавать структуру данных, состояющую из типа,
// переданного в квадратных скобках.
public class Stack<E> implements Iterable<E> {
    // Массив типа Object, так как все классы является наследниками данного класса. Нельзя создать объект с типом E, так
    // как он зараннее неопределен, поэтому приходиться использовать класс Object.
    private Object[] array;
    // Переменная, хранящая последний введенный элемент
    private int top;

    //Конструктор, в который передаем размер массива
    public Stack(int size) {
        // Инициализируем массив размера size
        array = new Object[size];
        // -1 значит отсутсвие элементов
        top = -1;
    }

    public void push(E element) {
        // Проверка на то что наш массив не заполнен
        if (top < array.length - 1) {
            // Сначала увеличиваем переменную, а потом
            array[++top] = element;
        }
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        // Приводим элемент к типу E, т.к. наши элементы массива имеют тип Object
        // Уменьшаем переменную top после
        return (E) array[top--];
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        // Приводим элемент к типу E, т.к. наши элементы массива имеют тип Object
        return (E) array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    // Переопределенный метод, который возвращает объект класса MyIterator, который в свою очередь реализует проход
    // по массиву
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
