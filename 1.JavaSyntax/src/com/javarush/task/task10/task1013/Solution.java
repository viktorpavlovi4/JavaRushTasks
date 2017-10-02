package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String name;
        private boolean sex;
        private byte age;
        private short weight;
        private Human parent;
        private Human child;

        public Human () {
        }

        public Human (byte age) {
            this.age = age;
        }

        public Human (short weight) {
            this.weight = weight;
        }

        public Human (String name) {
            this.name = name;
        }

        public Human (boolean sex) {
            this.sex = sex;
        }

        public Human (String name, boolean sex) {
            this.name = name;
            this.sex = sex;
        }

        public Human (String name, boolean sex, byte age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human (String name, boolean sex, byte age, short weight) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.weight = weight;
        }

        public Human (String name, boolean sex, byte age, short weight, Human parent) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.weight = weight;
            this.parent = parent;
        }

        public Human (String name, boolean sex, byte age, short weight, Human parent, Human child) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.weight = weight;
            this.parent = parent;
            this.child = child;
        }
    }
}
