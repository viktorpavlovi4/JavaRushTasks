package com.javarush.task.task29.task2909.car;

/**
 * Created by XE on 14.07.2017.
 */
public class Sedan extends Car {
    public Sedan(int numberOfPassengers) {
        super(SEDAN, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_SEDAN_SPEED;
    }
}
