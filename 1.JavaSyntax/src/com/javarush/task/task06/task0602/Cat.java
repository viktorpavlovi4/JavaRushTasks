package com.javarush.task.task06.task0602;

/* 
Пустые кошки, пустые псы
*/

public class Cat {
    public static void main(String[] args) {

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Cat was destroyed");
}
}

class Dog {

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Dog was destroyed");
    }
}
