package com.javarush.task.task29.task2909.car;

/**
 * Created by XE on 14.07.2017.
 */
public class Truck extends Car {
    public Truck(int numberOfPassengers) {
        super(TRUCK, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_TRUCK_SPEED;
    }
}