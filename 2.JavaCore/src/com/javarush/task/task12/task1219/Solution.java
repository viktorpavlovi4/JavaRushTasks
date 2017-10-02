package com.javarush.task.task12.task1219;

/* 
Fly, Run, Swim для классов Human, Duck, Penguin, Airplane
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface Fly {
        public void fly();
    }

    public interface Run {
        public void run();
    }

    public interface Swim {
        public void swim();
    }


    public class Human implements Run, Swim {
        @Override
        public void swim() {

        }

        @Override
        public void run() {

        }
    }

    public class Duck implements Swim, Fly, Run {
        @Override
        public void fly() {

        }

        @Override
        public void swim() {

        }

        @Override
        public void run() {

        }
    }

    public class Penguin implements Swim, Run {
        @Override
        public void swim() {

        }

        @Override
        public void run() {

        }
    }

    public class Airplane implements Fly, Run{
        @Override
        public void run() {

        }

        @Override
        public void fly() {

        }
    }
}
