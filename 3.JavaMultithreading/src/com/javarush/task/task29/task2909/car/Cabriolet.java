package com.javarush.task.task29.task2909.car;

/**
 * Created by XE on 14.07.2017.
 */
public class Cabriolet extends Car {
    public Cabriolet(int numberOfPassengers) {
        super(CABRIOLET, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_CABRIOLET_SPEED;
    }
}
