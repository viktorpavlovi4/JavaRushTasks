package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        try {
            StatisticManager statisticManager = StatisticManager.getInstance();

            Cook cook1 = new Cook("Amigo");
            cook1.setQueue(orderQueue);
            Cook cook2 = new Cook("Bingo");
            cook2.setQueue(orderQueue);
            Thread cook1Thread = new Thread(cook1);
            cook1Thread.start();
            Thread cook2Thread = new Thread(cook2);
            cook2Thread.start();

            Waiter waiter = new Waiter();
            cook1.addObserver(waiter);
            cook2.addObserver(waiter);

            List<Tablet> tablets = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                Tablet tablet = new Tablet(i);
                tablet.setQueue(orderQueue);
                tablets.add(tablet);
            }

            /*
            tablet.addObserver(cook);
            tablet.createOrder();
*/
            Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
            thread.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
            thread.interrupt();

            cook1Thread.interrupt();
            cook2Thread.interrupt();

            try {
                cook1Thread.join();
                cook2Thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            DirectorTablet directorTablet = new DirectorTablet();
            directorTablet.printActiveVideoSet();
            directorTablet.printAdvertisementProfit();
            directorTablet.printArchivedVideoSet();
            directorTablet.printCookWorkloading();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
