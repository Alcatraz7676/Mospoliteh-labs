package com.company;

import com.company.task3.OddNumber;
import com.company.task6.Stack;
import com.company.task7.Queue;
import com.company.task8.Set;
import com.company.task8.SetUtils;
import com.company.task9.Worker;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // 1. Перевернуть массив [1,2,3,4,5,6] => [6,2,3,4,5,6]
	    // (Не совсем понял пример, но да ладно)
        System.out.println(" • First task");
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
        System.out.println("Before " + array1);
        array1 = task1(array1);
        System.out.println("After " + array1);

        // 2. Упорядочить массив [1,1,0,1,0,0,1,1] => [0,0,0,0,1,1,1,1]
        // (Опять непонятный пример, хз почему после сортировки стало 4 нуля и 4 единицы)
        System.out.println("\n • Second task");
        ArrayList<Integer> array2 = new ArrayList<Integer>(Arrays.asList(1,1,0,1,0,0,1,1));
        System.out.println("Before " + array2);
        array2 = task2(array2);
        System.out.println("After " + array2);

        // 3. Найти нечетное число которое встречается наиболее число раз [1,2,1,2,3,3,4,3] => [3]
        System.out.println("\n • Third task");
        ArrayList<Integer> array3 = new ArrayList<Integer>(Arrays.asList(1,2,1,2,3,3,4,3));
        System.out.println("Array: " + array3);
        int mostPopularNum = task3(array3);
        if (mostPopularNum == 0) {
            System.out.println("There is no odd numbers in array!");
        } else {
            System.out.println("Most popular odd number is " + mostPopularNum);
        }

        // 4. Разделить массив на нечетные и четные числа [12, 3, 9, 11, 4, 10] => [12, 4, 10, 3, 9, 11]
        System.out.println("\n • Fourth task");
        ArrayList<Integer> array4 = new ArrayList<Integer>(Arrays.asList(12, 3, 9, 11, 4, 10));
        System.out.println("Before " + array4);
        array4 = task4(array4);
        System.out.println("After " + array4);

        // 5. Найти два числа в массиве сумма которых равна заданному числу либо сообщить что такого числа нет
        // [1, 11, 8, 9, 82, 7], sum = 8 => [1, 7]
        System.out.println("\n • Fifth task");
        ArrayList<Integer> array5 = new ArrayList<Integer>(Arrays.asList(1, 11, 8, 9, 82, 7));
        System.out.println("Array: " + array5 + ", sum = 8");
        ArrayList<Integer> numbers = task5(array5, 8);
        if (numbers.get(0) == 0 && numbers.get(1) == 0)
            System.out.println("There is such numbers");
        else
            System.out.println("The numbers is " + numbers.get(0) + " and " + numbers.get(1));

        // 6. Определить класс Stack на базе массива
        // Ниже приведен пример использования класса Stack (сама коллекция лежит в папке task6).
        System.out.println("\n • Sixth task");
        Stack<Integer> stack = new Stack<Integer>(5);
        if (stack.isEmpty())
            System.out.println("Stack is empty");
        stack.push(20);
        stack.push(74);
        stack.push(1488);
        if (!stack.isEmpty()) {
            System.out.println("Stack is not empty");
            System.out.print("Stack: [");
            for (Integer element : stack) {
                if (element != null)
                    System.out.print(element + ", ");
            }
            System.out.println("]");
        }
        System.out.println("Call peek method on stack: " + stack.peek());
        System.out.println("Call pop method on stack: " + stack.pop());
        System.out.println("And peek again: " + stack.peek());

        // 7 Реализовать структуру данных Очередь на базе массива в виде класса.
        // Ниже приведен пример использования класса Queue (сама коллекция лежит в папке task7).
        System.out.println("\n • Seventh task");
        Queue<Integer> queue = new Queue<Integer>(5);
        if(stack.isEmpty())
            System.out.println("Queue is empty");
        queue.insert(11);
        queue.insert(1337);
        queue.insert(-777);
        if (!queue.isEmpty()) {
            System.out.println("Queue is not empty");
            System.out.print("Queue: {");
            for (Integer element : queue) {
                if (element != null)
                    System.out.print(element + ", ");
            }
            System.out.println("]");
        }
        System.out.println("Call peek method on stack: " + queue.peekFront());
        System.out.println("Call pop method on stack: " + queue.remove());
        System.out.println("Call pop method on stack: " + queue.remove());
        System.out.println("Call pop method on stack: " + queue.remove());
        System.out.println("Call pop method on stack: " + queue.remove());
        if (queue.isEmpty())
            System.out.println("Queue is empty");

        // 8. Определить класс Set на основе множества целых чисел, n = размер. Создать методы для определения
        // пересечения и объединения множеств.
        System.out.println("\n • Eighth task");
        Set set1 = new Set(new ArrayList<Integer>(Arrays.asList(6, 9, 1, 2, 4, 9)));
        System.out.print("Set1: ");
        set1.print();
        Set set2 = new Set(5);
        set2.add(6);
        set2.add(6);
        set2.add(5);
        set2.add(4);
        set2.add(9);
        set2.add(3);
        System.out.print("Set2: ");
        set2.print();
        System.out.print("Set crossing: ");
        SetUtils.setCrossing(set1, set2).print();
        System.out.print("Set association: ");
        SetUtils.setAssociation(set1, set2).print();

        // 9. Определить класс Рабочий с полями Имя, Возраст, Пол, Должность. Создать индексатор для объектов класса.
        // Проследить, чтобы поля напрямую в других классах были недоступны. Создать функцию вывода информации о рабочем.
        System.out.println("\n • Ninth task");
        Worker worker1 = new Worker("Max", 20, 'M', "Programmer");
        System.out.println(worker1.toString());
        Worker worker2 = new Worker("Fred", 24, 'M', "Manager");
        System.out.println(worker2.toString());
        Worker worker3 = new Worker("Anna", 19, 'F', "Actress");
        System.out.println(worker3.toString());
    }

    private static ArrayList<Integer> task1(ArrayList<Integer> array) {
        for(int i = 0; i < array.size() / 2; i++) {
            int numFromEnd = array.size() - i;
            // Вставляем элементы из начала в конец
            array.set(array.size() - i - 1, array.get(i));
            // И потом из конца в начало
            array.set(i, numFromEnd);
        }
        return array;
    }

    private static ArrayList<Integer> task2(ArrayList<Integer> array) {
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        for (Integer num : array) {
            // Если это ноль, то вставляем в начало
            if (num == 0)
                newArray.add(0, 0);
            // Если 1, то в конец
            else
                newArray.add(1);
        }
        return newArray;
    }

    private static int task3(ArrayList<Integer> array) {
        ArrayList<OddNumber> oddNumbers = new ArrayList<OddNumber>();
        for (Integer num : array) {
            // Проверяем на нечетность
            if (num % 2 == 1) {
                boolean numOccured = false;
                for (OddNumber oddNum : oddNumbers) {
                    if (oddNum.getNumber().equals(num)) {
                        oddNum.anotherOccur();
                        numOccured = true;
                        break;
                    }
                }
                // Если это первое такое нечетное число из массива
                if(!numOccured)
                    oddNumbers.add(new OddNumber(num));
            }
        }
        int mostPopularOddNumber = 0;
        int numberOfOccurrence = 0;
        for (OddNumber oddNumber : oddNumbers) {
            if (oddNumber.HowManyTimesOccur() > numberOfOccurrence) {
                mostPopularOddNumber = oddNumber.getNumber();
                numberOfOccurrence = oddNumber.HowManyTimesOccur();
            }
        }

        return mostPopularOddNumber;
    }

    private static ArrayList<Integer> task4(ArrayList<Integer> array) {
        ArrayList<Integer> evenNumbers = new ArrayList<Integer>();
        ArrayList<Integer> oddNumbers = new ArrayList<Integer>();
        for (Integer num : array) {
            if (num % 2 == 0)
                evenNumbers.add(num);
            else
                oddNumbers.add(num);
        }
        evenNumbers.addAll(oddNumbers);
        return evenNumbers;
    }

    private static ArrayList<Integer> task5(ArrayList<Integer> array, int sum) {
        Integer firstNum;
        Integer secondNum;
        for (int i = 0; i < array.size(); i++) {
            // Проверяем что первое число не больше самой суммы
            if (array.get(i) <= sum) {
                firstNum = array.get(i);
                for (int k = i + 1; k < array.size(); k++) {
                    if ((firstNum + array.get(k)) == sum) {
                        secondNum = array.get(k);
                        return new ArrayList<Integer>(Arrays.asList(firstNum, secondNum));
                    }
                }
            }
        }
        return new ArrayList<Integer>(Arrays.asList(0, 0));
    }
}
