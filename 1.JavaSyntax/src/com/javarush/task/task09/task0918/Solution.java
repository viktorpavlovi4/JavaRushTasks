package com.javarush.task.task09.task0918;

/* 
Все свои, даже исключения
*/

public class Solution {
    public static void main(String[] args) {
        try {
            f();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void f() throws MyException, MyException2, MyException3, MyException4 {
        int i = (int) (Math.random() * 4);
        if (i == 0)
            throw new MyException();
        if (i == 1)
            throw new MyException2();
        if (i == 2)
            throw new MyException3();
        if (i == 3)
            throw new MyException4();

    }

    static class MyException extends Exception {

    }

    static class MyException2 extends MyException {
    }

    static class MyException3 extends RuntimeException {
    }

    static class MyException4 extends Error {
    }
}

