package com.javarush.task.task29.task2909.user;

import java.util.concurrent.atomic.AtomicInteger;

public class UserHelper {
    private User userAnya = new User("Аня", "Смирнова", 10);
    private User userRoma = new User("Рома", "Виноградов", 30);
    private User userUra = new User("Юра", "Карп", 28);

    public void printUsers() {
        userAnya.printInfo();
        userAnya.printAdditionalInfo();

        userRoma.printInfo();
        userRoma.printAdditionalInfo();
    }

/*
    private boolean ageLessThan16(User user) {
        if (user.getAge() < 16) {
            return true;
        }
        return false;
    }
*/
    public int calculateAverageAge() {
        return (userAnya.getAge() + userRoma.getAge() + userUra.getAge()) / 3;
    }

    public int calculateRate(AtomicInteger base, int age, boolean hasWork, boolean hasHouse) {
        int rate = base.intValue();
        
        rate += age/100;
        rate *= hasWork ? 1.1 : 0.9;
        rate *= hasHouse ? 1.1 : 0.9;

        return rate;
    }

    public String getBossName(User user) {
        return user.getBoss();
    }
}