package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by XE on 29.07.2017.
 */
public class MyThread extends Thread {
    public static AtomicInteger counter = new AtomicInteger(1);

    /*static {
        setPriority(counter.getAndIncrement());
    }*/

    public void prioritySet() {
        setPriority(counter.getAndIncrement());
        counter.compareAndSet(11,1);
    }

    public MyThread() {
        prioritySet();
    }

    public MyThread(Runnable target) {
        super(target);
        prioritySet();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        if (counter.get() > group.getMaxPriority()) {
            if (counter.get() == 10) {
                setPriority(group.getMaxPriority());
                counter = new AtomicInteger(1);
            } else {
                setPriority(group.getMaxPriority());
                counter.getAndIncrement();
            }
        }
        else setPriority(counter.getAndIncrement());
    }

    public MyThread(String name) {
        super(name);
        prioritySet();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        if (counter.get() > group.getMaxPriority()) {
            if (counter.get() == 10) {
                setPriority(group.getMaxPriority());
                counter = new AtomicInteger(1);
            } else {
                setPriority(group.getMaxPriority());
                counter.getAndIncrement();
            }
        }
        else setPriority(counter.getAndIncrement());
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        prioritySet();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        if (counter.get() > group.getMaxPriority()) {
            if (counter.get() == 10) {
                setPriority(group.getMaxPriority());
                counter = new AtomicInteger(1);
            } else {
                setPriority(group.getMaxPriority());
                counter.getAndIncrement();
            }
        }
        else setPriority(counter.getAndIncrement());
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        if (counter.get() > group.getMaxPriority()) {
            if (counter.get() == 10) {
                setPriority(group.getMaxPriority());
                counter = new AtomicInteger(1);
            } else {
                setPriority(group.getMaxPriority());
                counter.getAndIncrement();
            }
        }
        else setPriority(counter.getAndIncrement());
    }
}