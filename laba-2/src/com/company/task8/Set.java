package com.company.task8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Сет(множество) - это структура данных, которая содержит в себе неповторяющиеся значения.
// Данный класс использует дженерики(generic types). Благодаря им можно создавать структуру данных, состояющую из типа,
// переданного в квадратных скобках.
public class Set<E> implements Iterable<E> {
    // Использую ArrayList потому что удобнее(меньше кода писать) (¬‿¬)
    private ArrayList<E> array;

    // Так как нам нужно определить класс Set на основе множества целых чисел, либо указанного размера, то надо будет
    // написать два конструктора.

    // Конструктор на основе множества
    public Set(List<E> array) {
        this.array = new ArrayList<E>();
        // Проходим по переданному массиву, и добавляем элементы с неповторяюшемся значениями
        for (E element : array) {
            if (!contains(element))
                this.array.add(element);
        }
    }

    // Конструктор на основе размера
    public Set(int size) {
        array = new ArrayList<E>(size);
    }

    public int getSize() {
        return array.size();
    }

    public void print() {
        System.out.println(array);
    }

    // Добавляет переданное множество к множеству в классе
    public void add(Set<E> set) {
        // Проходим по переданному множеству, и добавляем элементы с неповторяюшемся значениями
        for (E element : set) {
            if (!contains(element))
                array.add(element);
        }
    }

    // Добавляет элемент к множеству, предварительно проверив на наличие элемента с таким же значением в массиве
    public void add(E item) {
        for (E element : array) {
            if (element.equals(item))
                return;
        }
        array.add(item);
    }

    // Этот метод не проверяет, хранит ли массив такое значение (Использовать с осторожностью)
    public void addQuick(E item) {
        array.add(item);
    }

    // Данный метод проверяет, содержит ли массив значение, переданное в параметре
    public boolean contains(E item) {
        for (E element : array) {
            if (element.equals(item))
                return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator<E> {

        private int index = 0;

        public boolean hasNext() {
            return index < array.size();
        }

        @SuppressWarnings("unchecked")
        public E next() {
            return array.get(index++);
        }

        public void remove() {
            throw new UnsupportedOperationException("not supported yet");
        }
    }
}
