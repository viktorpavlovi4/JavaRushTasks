package com.javarush.task.task09.task0901;

/* 
Возвращаем StackTrace
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        method1();
    }

    public static StackTraceElement[] method1() {
        method2();
        //напишите тут ваш код
        StackTraceElement[] method2Stack = Thread.currentThread().getStackTrace();
        return method2Stack;
    }

    public static StackTraceElement[] method2() {
        method3();
        //напишите тут ваш код
        StackTraceElement[] method3Stack = Thread.currentThread().getStackTrace();
        return method3Stack;
    }

    public static StackTraceElement[] method3() {
        method4();
        //напишите тут ваш код
        StackTraceElement[] method4Stack = Thread.currentThread().getStackTrace();
        return method4Stack;
    }

    public static StackTraceElement[] method4() {
        method5();
        //напишите тут ваш код
        StackTraceElement[] method5Stack = Thread.currentThread().getStackTrace();
        return method5Stack;
    }

    public static StackTraceElement[] method5() {
        //напишите тут ваш код
        StackTraceElement[] method6Stack = Thread.currentThread().getStackTrace();
        return method6Stack;
    }
}
