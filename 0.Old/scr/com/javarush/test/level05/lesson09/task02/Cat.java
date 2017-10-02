package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача конструктора – сделать объект валидным. Например, если вес не известен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    private String name = null;
    private int weight = 7;
    private int age = 3;
    private String color;
    private String address = null;

    public Cat (String name){
        this.name = name;
    }
    public Cat (String name, int weight, int age){
        this.name = name + weight + age;
    }
    public Cat (String name, int age){
        this.name = name + weight + age;
    }
    public Cat (int weight, String color){
        this.name = name + weight + age + color;
    }
    public Cat (int weight, String color, String address){
        this.name = name + weight + age + color + address;
    }
}
