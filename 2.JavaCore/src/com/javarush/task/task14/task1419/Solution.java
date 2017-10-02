package com.javarush.task.task14.task1419;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.EmptyStackException;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }
        //напишите тут ваш код
        try {
            throw new ArrayIndexOutOfBoundsException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new ArrayStoreException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new ClassCastException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new ConcurrentModificationException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new EmptyStackException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new IllegalArgumentException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new IllegalMonitorStateException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new IllegalStateException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new IllegalThreadStateException();
        } catch (Exception e) {
            exceptions.add(e);
        }
    }
}
