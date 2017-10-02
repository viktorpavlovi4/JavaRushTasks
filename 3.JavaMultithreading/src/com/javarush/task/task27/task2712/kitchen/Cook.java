package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Restaurant;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable {
    private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();
    private String name;
    private boolean busy;

    public boolean isBusy() {
        return busy;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void startCookingOrder(Order order) {
        busy = true;
        int cookingTime = order.getTotalCookingTime();
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(
                order.getTablet().toString(),
                this.name,
                cookingTime*60,
                order.getDishes()));

        ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + cookingTime + "min");

        setChanged();
        notifyObservers(order);
        try {
            Thread.sleep(cookingTime*10);
        } catch (InterruptedException e) {

        }
        busy = false;
    }

    @Override
    public void run() {
//        Set<Cook> cooks = StatisticManager.getInstance().getCooks();
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
            if (!queue.isEmpty()) {
//                for (Cook cook : cooks) {
                    if (!isBusy()) {
                        Order order = queue.poll();
                        if (order != null)
                            startCookingOrder(order);
                    }
                    if (queue.isEmpty())
                        break;
//                }
            }
        }
    }
}