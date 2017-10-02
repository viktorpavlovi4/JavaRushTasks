package com.javarush.task.task14.task1417;

/**
 * Created by XE on 03.05.2017.
 */
public class USD extends Money {
    public USD(double amount) {
        super(amount);
    }

    public String getCurrencyName() {
        return "USD";
    }
}
