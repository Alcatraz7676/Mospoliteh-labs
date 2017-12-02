package com.company.task8;

public class SetUtils {

    public static Set setCrossing(Set set1, Set set2) {
        Set set;
        // Создаем новый сет с размером большего сета
        if (set1.size() > set2.size())
            set = new Set(set1.size());
        else
            set = new Set(set2.size());

        for (Integer element1 : set1) {
            if (set.contains(element1))
                continue;
            for (Integer element2 : set2) {
                if (element1.equals(element2)) {
                    // Здесь я использую данный метод, потому что мы уже проверили сет на содержание элемента
                    set.addQuick(element2);
                    break;
                }
            }
        }
        return set;
    }

    public static Set setAssociation(Set set1, Set set2) {
        Set set;
        // Создаем новый сет с размером большего сета
        if (set1.size() > set2.size())
            set = new Set(set1.size());
        else
            set = new Set(set2.size());

        // Проверка на включение уже встроена в структуру (•ᴗ•)
        set.add(set1);
        set.add(set2);

        return set;
    }
}
