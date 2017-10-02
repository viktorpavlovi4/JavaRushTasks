package com.javarush.task.task12.task1205;

/* 
Или «Корова», или «Кит», или «Собака», или «Неизвестное животное»
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Dog()));
        System.out.println(getObjectType(new Whale()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o) {
        //Напишите тут ваше решение
        if (o.getClass().getSimpleName().equals("Cow"))
            return "Корова";
        else if (o.getClass().getSimpleName().equals("Dog"))
            return "Собака";
        else if (o.getClass().getSimpleName().equals("Whale"))
            return "Кит";
        else return "Неизвестное животное";
    }

    public static class Cow {
    }

    public static class Dog {
    }

    public static class Whale {
    }

    public static class Pig {
    }
}
