package com.company.task8;

public class SetUtils {

    // Пересечением множеств является множество, состоящие из элементов, содержащихся в обоих множествах
    public static Set setCrossing(Set set1, Set set2) {
        Set set;
        // Создаем новый сет с размером большего сета
        if (set1.getSize() > set2.getSize())
            set = new Set(set1.getSize());
        else
            set = new Set(set2.getSize());

        // Проходим по первому множеству
        for (Object element1 : set1) {
            // Если такое значение уже встречалось то переходим дальше
            if (set.contains(element1))
                continue;
            // Теперь проходим по второму множеству
            for (Object element2 : set2) {
                // Если значения совпадают
                if (element1.equals(element2)) {
                    // Добавляем элемент в общий сет (Здесь я использую метод addQuick, потому что мы уже проверили сет на
                    // содержание элемента)
                    set.addQuick(element2);
                    break;
                }
            }
        }
        return set;
    }

    // Объединением множеств является множество содержащая все элементы первого и второго множества
    public static Set setAssociation(Set set1, Set set2) {
        Set set;
        // Создаем новый сет с размером большего сета
        if (set1.getSize() > set2.getSize())
            set = new Set(set1.getSize());
        else
            set = new Set(set2.getSize());

        // Просто добавляем первое и второе множество
        // Проверка на включение уже встроена в структуру (•ᴗ•)
        set.add(set1);
        set.add(set2);

        return set;
    }
}
