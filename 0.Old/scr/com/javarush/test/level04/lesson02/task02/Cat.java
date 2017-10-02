package com.javarush.test.level04.lesson02.task02;

/* Реализовать метод addNewCat
Реализовать метод addNewCat, чтобы при его вызове (т.е. добавлении нового кота), количество котов увеличивалось на 1. За количество котов отвечает переменная catsCount.
*/

public class Cat {
    private static int catsCount = 0;

    public static void addNewCat() {
        //напишите тут ваш код
        Cat.catsCount++;
    }

    public static void main(String[] args) {
        addNewCat();
        System.out.println(catsCount);
        addNewCat();
        System.out.println(catsCount);
    }
}
