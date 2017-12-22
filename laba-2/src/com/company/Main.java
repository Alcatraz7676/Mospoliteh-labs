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
        // Инициализируем массив с элементами
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
        // Выводим элементы до переворота
        System.out.println("Before " + array1);
        // Результат выполнения метода task1 - перевернутый массив, поэтому присваиваем этой же переменной данный массив
        array1 = task1(array1);
        // Выводим элементы после переворота
        System.out.println("After " + array1);

        // 2. Упорядочить массив [1,1,0,1,0,0,1,1] => [0,0,0,0,1,1,1,1]
        // (Опять непонятный пример, хз почему после сортировки стало 4 нуля и 4 единицы)
        System.out.println("\n • Second task");
        // Действия ниже такие же как и в 1 задании
        ArrayList<Integer> array2 = new ArrayList<Integer>(Arrays.asList(1,1,0,1,0,0,1,1));
        System.out.println("Before " + array2);
        array2 = task2(array2);
        System.out.println("After " + array2);

        // 3. Найти нечетное число которое встречается наиболее число раз [1,2,1,2,3,3,4,3] => [3]
        // В данном примере использовался класс OddNumber(папка task3)
        System.out.println("\n • Third task");
        ArrayList<Integer> array3 = new ArrayList<Integer>(Arrays.asList(1,2,1,2,3,3,4,3));
        System.out.println("Array: " + array3);
        // Результат выполнения метода task3 - нечетное число, которое встречается большее число раз, присваиваем это
        // значение переменной mostPopularNum
        int mostPopularNum = task3(array3);
        // Если метод task3 вернул 0, то в массиве нет нечетных чисел
        if (mostPopularNum == 0) {
            System.out.println("There is no odd numbers in array!");
        } else {
            System.out.println("Most popular odd number is " + mostPopularNum);
        }

        // 4. Разделить массив на нечетные и четные числа [12, 3, 9, 11, 4, 10] => [12, 4, 10, 3, 9, 11]
        System.out.println("\n • Fourth task");
        // Действия ниже такие же как и в 1 задании
        ArrayList<Integer> array4 = new ArrayList<Integer>(Arrays.asList(12, 3, 9, 11, 4, 10));
        System.out.println("Before " + array4);
        array4 = task4(array4);
        System.out.println("After " + array4);

        // 5. Найти два числа в массиве сумма которых равна заданному числу либо сообщить что такого числа нет
        // [1, 11, 8, 9, 82, 7], sum = 8 => [1, 7]
        System.out.println("\n • Fifth task");
        // Инициализируем массив с элементами и сумму чисел, которую нам надо найти
        ArrayList<Integer> array5 = new ArrayList<Integer>(Arrays.asList(1, 11, 8, 9, 82, 7));
        int sum = 8;
        // Выводим элементы массива и сумму
        System.out.println("Array: " + array5 + ", sum = " + sum);
        // Результатом работы метода task5 будет массив состоящий из 2 элементов, чисел из которых можно получить нашу
        // сумму
        ArrayList<Integer> numbers = task5(array5, sum);
        // Если оба элемента равен нулю, то в массиве нет таких чисел, из которых можно было бы составить
        // заданную сумму
        if (numbers.get(0) == 0 && numbers.get(1) == 0)
            System.out.println("There is no such numbers");
        else
            System.out.println("The numbers is " + numbers.get(0) + " and " + numbers.get(1));

        // 6. Определить класс Stack на базе массива
        // Ниже приведен пример использования класса Stack (сама коллекция лежит в папке task6).
        System.out.println("\n • Sixth task");
        // Инициализируем стек с 5 элементами(все они равны null)
        Stack<String> stack = new Stack<String>(5);
        // Проверяем стек на пустоту(метод вернет true)
        if (stack.isEmpty())
            System.out.println("Stack is empty");
        // Добавляем в массив элементы
        stack.push("lol");
        stack.push("kek");
        stack.push("cheburek");
        // Если массив не пустой(а он не пустой)
        if (!stack.isEmpty()) {
            System.out.println("Stack is not empty");
            System.out.print("Stack: [");
            // Печатаем элементы(у последнего элемента будет запятая, но мне лень это фиксить)
            for (String element : stack) {
                if (element != null)
                    System.out.print(element + ", ");
            }
            System.out.println("]");
        }
        // Метод peek возвращает последний введенный элемент, при этом не удалля его
        System.out.println("Call peek method on stack: " + stack.peek());
        // Метод pop возвращает последний введенный элемент, при этом удалля его
        System.out.println("Call pop method on stack: " + stack.pop());
        // Снова вызываем метод peek чтобы убедиться что элемент был удален
        System.out.println("And peek again: " + stack.peek());

        // 7. Реализовать структуру данных Очередь на базе массива в виде класса.
        // Ниже приведен пример использования класса Queue (сама коллекция лежит в папке task7).
        System.out.println("\n • Seventh task");
        // Инициализируем очередь с 5 элементами(все они равны null)
        Queue<Integer> queue = new Queue<Integer>(5);
        // Ниже прововодит те же операции что и со стеком
        if(queue.isEmpty())
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
        // Метод peek вернет первый элемент в очереди (то есть следующий на удаление)
        // Метод remove удалит первый элемент и вернет его значение
        System.out.println("Call peek method on queue: " + queue.peekFront());
        System.out.println("Call remove method on queue: " + queue.remove());
        System.out.println("Call remove method on queue: " + queue.remove());
        System.out.println("Call peek method on queue: " + queue.peekFront());
        if (!queue.isEmpty()) {
            System.out.println("Queue is not empty");
            System.out.print("Queue: {");
            for (Integer element : queue) {
                if (element != null)
                    System.out.print(element + ", ");
            }
            System.out.println("]");
        }
        System.out.println("Call remove method on queue: " + queue.remove());
        if (queue.isEmpty())
            System.out.println("Queue is empty");

        // 8. Определить класс Set на основе множества целых чисел, n = размер. Создать методы для определения
        // пересечения и объединения множеств.
        System.out.println("\n • Eighth task");
        // Инициализируем массив с элементами с готовыми числами
        Set<Integer> set1 = new Set<Integer>(Arrays.asList(6, 9, 1, 2, 4, 9));
        // Печатаем наше первое множество
        System.out.print("Set1: ");
        set1.print();
        // Инициализируем множество с 5 элементами(все они равны null)
        Set<Integer> set2 = new Set<Integer>(5);
        // Добавляем поочередно элементы в множество(элементы с повторяющимеся значениями не будут добавлены второй раз)
        set2.add(6);
        set2.add(6);
        set2.add(5);
        set2.add(4);
        set2.add(9);
        set2.add(3);
        // Печатаем наше второе множество
        System.out.print("Set2: ");
        set2.print();
        // Печатаем пересечение множеств
        System.out.print("Set crossing: ");
        SetUtils.setCrossing(set1, set2).print();
        // Печатаем объединение множеств
        System.out.print("Set association: ");
        SetUtils.setAssociation(set1, set2).print();

        // 9. Определить класс Рабочий с полями Имя, Возраст, Пол, Должность. Создать индексатор для объектов класса.
        // Проследить, чтобы поля напрямую в других классах были недоступны. Создать функцию вывода информации о рабочем.
        System.out.println("\n • Ninth task");
        // Создаем рабочих и печатаем сведения о них
        Worker worker1 = new Worker("Max", 20, 'M', "Programmer");
        System.out.println(worker1.toString());
        Worker worker2 = new Worker("Angelina", 24, 'F', "Manager");
        System.out.println(worker2.toString());
        Worker worker3 = new Worker("Anna", 19, 'F', "Actress");
        System.out.println(worker3.toString());
    }

    private static ArrayList<Integer> task1(ArrayList<Integer> array) {
        // Проходим до середины массива
        for(int i = 0; i < array.size() / 2; i++) {
            // Запоминаем значение элемента для свапа с конца, так как значение этого элемента в массиве будет
            // перезаписано далее
            int numFromEnd = array.get(array.size() - i - 1);
            // Вставляем элемент из начала в конец(первый параметр отвечает за то, в какой индекс будет вписан элемент,
            // и второй за то какое значение будет вписано)
            array.set(array.size() - i - 1, array.get(i));
            // И потом из конца в начало
            array.set(i, numFromEnd);
        }
        // Возвращаем наш отсортированный массив
        return array;
    }

    private static ArrayList<Integer> task2(ArrayList<Integer> array) {
        // Создаем пустой массив
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        // Проходим по переданному массиву
        for (Integer num : array) {
            // Если это ноль, то вставляем в начало
            if (num == 0)
                newArray.add(0, 0);
            // Если 1, то в конец
            else
                newArray.add(1);
        }
        // Возвращаем полученный массив
        return newArray;
    }

    private static int task3(ArrayList<Integer> array) {
        // Массив состоящий из объектов OddNumber(пока что он пуст)
        ArrayList<OddNumber> oddNumbers = new ArrayList<OddNumber>();
        // Проходим по переданному нам массиву чисел
        for (Integer num : array) {
            // Проверяем на нечетность
            if (num % 2 == 1) {
                // По умолчанию сичтаем что данное число нам еще не встретилось
                boolean numOccurred = false;
                // Проходим по массиву состоящему из нечетных чисел(в начале он пуст, так что в первый раз пропускаем
                // данный блок)
                for (OddNumber oddNum : oddNumbers) {
                    // Проверяем не встречалось ли уже такое число раньше
                    if (oddNum.getNumber().equals(num)) {
                        // Если да то добавляем этому числу еще одно вхождение и меняем булево значение на true
                        oddNum.anotherOccur();
                        numOccurred = true;
                        break;
                    }
                }
                // Если это первое такое нечетное число из массива, то добавлеям его в массив нечетных чисел
                if(!numOccurred)
                    oddNumbers.add(new OddNumber(num));
            }
        }
        // После нахождения всех нечетных чисел, и количества их вхождения нам надо найти самый встречаемый элемент
        int mostPopularOddNumber = 0;
        int numberOfOccurrence = 0;
        for (OddNumber oddNumber : oddNumbers) {
            // Если количество вхождений этого числа больше чем у просмотренных раннее, то запоминаем значение и кол-во
            // вхождений этого числа
            if (oddNumber.HowManyTimesOccur() > numberOfOccurrence) {
                mostPopularOddNumber = oddNumber.getNumber();
                numberOfOccurrence = oddNumber.HowManyTimesOccur();
            }
        }
        // Возвращаем это число
        return mostPopularOddNumber;
    }

    private static ArrayList<Integer> task4(ArrayList<Integer> array) {
        // Массив, состоящий из четных чисел
        ArrayList<Integer> evenNumbers = new ArrayList<Integer>();
        // Массив, состоящий из нечетных чисел
        ArrayList<Integer> oddNumbers = new ArrayList<Integer>();
        // Проходим по переданному массиву
        for (Integer num : array) {
            // Если число четно то добавляем в массив четных
            if (num % 2 == 0)
                evenNumbers.add(num);
            else
                // Если число нечетно то добавляем в массив нечетных
                oddNumbers.add(num);
        }
        // Добавляем массив нечетных в конец массива четных
        evenNumbers.addAll(oddNumbers);
        // Возвращаем данный массив
        return evenNumbers;
    }

    private static ArrayList<Integer> task5(ArrayList<Integer> array, int sum) {
        Integer firstNum;
        Integer secondNum;
        // Проходим по массиву
        for (int i = 0; i < array.size(); i++) {
            // Проверка того что первое число не больше самой суммы
            if (array.get(i) <= sum) {
                // Запоминаем первое число
                firstNum = array.get(i);
                // Проходим по оставшейся части массива
                for (int k = i + 1; k < array.size(); k++) {
                    // Если первое число плюс следующее число из массива равно сумме, то возвращаем эти числа
                    if ((firstNum + array.get(k)) == sum) {
                        secondNum = array.get(k);
                        return new ArrayList<Integer>(Arrays.asList(firstNum, secondNum));
                    }
                }
            }
        }
        // Если мы так и не нашли такие числа то возвращаем два нуля
        return new ArrayList<Integer>(Arrays.asList(0, 0));
    }
}
