package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by XE on 03.06.2017.
 */
public class Hippodrome {
    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static Hippodrome game;

    public Horse getWinner() {
        int index = 0;
        for (int i = 0; i < horses.size(); i++) {
            if (horses.get(i).getDistance() > horses.get(index).getDistance())
                index = i;
        }
        return horses.get(index);
    }

    public void printWinner() {
        StringBuilder s = new StringBuilder("Winner is " + getWinner().getName() + "!");
        System.out.println(s);
    }

    public void move(){
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print(){
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public void run(){
        for (int i = 0; i < 100; i++) {
            try {
                move();
                print();
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Horse horse1 = new Horse("1", 3.0, 0.0);
        Horse horse2 = new Horse("2", 3.0, 0.0);
        Horse horse3 = new Horse("3", 3.0, 0.0);
        game = new Hippodrome(Arrays.asList(horse1, horse2, horse3));
        game.run();
        game.printWinner();
    }
}
