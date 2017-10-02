package com.javarush.task.task12.task1214;

/* 
Класс Cow от Animal
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static abstract class Animal {
        public abstract String getName();
    }

    public static class Cow extends Animal {
        String name = "MY";
        public String getName() { return this.name; }
    }

}
