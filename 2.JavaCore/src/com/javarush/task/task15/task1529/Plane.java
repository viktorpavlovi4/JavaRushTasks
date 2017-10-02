package com.javarush.task.task15.task1529;

/**
 * Created by XE on 06.05.2017.
 */
public class Plane implements Flyable {
    int passengers;
    public void fly() {
        System.out.println("fly");
    }
    public Plane(int i) {
        this.passengers = i;
    }
}
