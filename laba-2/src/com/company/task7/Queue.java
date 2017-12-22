package com.company.task7;

import java.util.Iterator;

// Очередь - это структура данных, которая возвращает первый введенный элемент (то есть кто первый пришел, тот первый вышел)
// Данная очередь является кольцевой, то есть возможна такая ситуация: array[0, null, null, 5, 12]. То есть не null
// элементы разделены null'ами.
// Данный класс использует дженерики(generic types). Благодаря им можно создавать структуру данных, состояющую из типа,
// переданного в квадратных скобках.
public class Queue<E> implements Iterable<E> {
    // Массив типа Object, так как все классы является наследниками данного класса. Нельзя создать объект с типом E, так
    // как он зараннее неопределен, поэтому приходиться использовать класс Object.
    private Object[] array;
    // Индекс, указвающий на элемент, который должен быть удален следующим
    private int front;
    // Последний введенный элемент
    private int end;
    // Размер массива
    private int size;

    //Конструктор, в который передаем размер массива
    public Queue(int maxSize) {
        array = new Object[maxSize];
        front = 0;
        end = 0;
        size = 0;
    }

    public void insert(E item) {
        // Проверка на заполненность массива
        if (size != array.length) {
            // Если мы дошли до конца, то вводим элемент в начало.
            if (end == array.length - 1)
                end = 0;
            // Увеличиваем end после этого
            array[end++] = item;
            // А также размер массива
            size++;
        }
    }

    @SuppressWarnings("unchecked")
    public E remove() {
        // Запоминаем значение следующего элемента на удаление
        E temp = (E) array[front];
        // Если массив не пустой
        if (size != 0) {
            // Собственно удаляем элемент
            array[front] = null;
            // Увеличиваем индекс след. элемента на удаление
            front++;
            // Если индекс след. элемента выходит за границы массива
            if (front == array.length)
                front = 0;
            // Уменьшаем размер массива
            size--;
        }
        return temp;
    }

    @SuppressWarnings("unchecked")
    public E peekFront() {
        // Возвращаем след. элемент на удаление
        return (E) array[front];
    }

    public boolean isEmpty() {
        return size == 0;
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
