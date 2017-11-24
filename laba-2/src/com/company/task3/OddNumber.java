package com.company.task3;

public class OddNumber {
    private Integer number;
    private int howManyTimesOccur;

    public OddNumber(Integer number) {
        this.number = number;
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
