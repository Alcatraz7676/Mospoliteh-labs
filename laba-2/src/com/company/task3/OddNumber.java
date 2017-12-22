package com.company.task3;

// Данный класс используется для хранения значения нечетного числа и количества вхождения этого числа в массиве
public class OddNumber {
    private Integer number;
    private int howManyTimesOccur;

    public OddNumber(Integer number) {
        this.number = number;
        // Когда создаем объект, то число уже встретилось нам один раз
        howManyTimesOccur = 1;
    }

    public Integer getNumber() {
        return number;
    }

    public void anotherOccur() {
        howManyTimesOccur++;
    }

    public int HowManyTimesOccur() {
        return howManyTimesOccur;
    }

}
