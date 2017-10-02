package com.javarush.task.task14.task1413;

/**
 * Created by XE on 03.05.2017.
 */
public class Computer {
    private Monitor monitor = null;
    private Keyboard keyboard = null;
    private Mouse mouse = null;

    public Computer(Keyboard keyboard, Mouse mouse, Monitor monitor) {
        this.monitor = monitor;
        this.keyboard = keyboard;
        this.mouse = mouse;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public Mouse getMouse() {
        return mouse;
    }
}
