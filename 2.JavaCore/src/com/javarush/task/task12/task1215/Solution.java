package com.javarush.task.task12.task1215;

/* 
Классы Cat и Dog от Pet
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static abstract class Pet {
        public abstract String getName();

        public abstract Pet getChild();
    }

    public static class Cat extends Pet {
        String name;
        public String getName() { return this.name; }
        public Pet getChild() { return this; }
    }

    public static class Dog extends Pet {
        String name;
        public String getName() { return this.name; }
        public Pet getChild() { return this; }
    }

}
