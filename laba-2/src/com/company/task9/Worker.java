package com.company.task9;

public class Worker {
    private String name;
    private int age;
    private String gender;
    private String post;
    private int id;

    // Статическая переменная пренадлежит не экземплярам класса, а непосредственно классу, то есть при создании нового
    // объекта не будет создаваться новая переменная nextId, а использоваться одна на все объекты этого класса.
    private static int nextId = 0;

    public Worker(String name, int age, Character gender, String post) {
        this.name = name;
        this.age = age;
        switch (gender) {
            case 'M':
                this.gender = "Male";
                break;
            case 'F':
                this.gender = "Female";
                break;
        }
        this.post = post;
        id = nextId++;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", post='" + post + '\'' +
                ", id=" + id +
                '}';
    }
}
