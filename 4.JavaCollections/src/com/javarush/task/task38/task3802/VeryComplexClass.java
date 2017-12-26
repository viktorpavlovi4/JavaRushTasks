package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        //напишите тут ваш код
        Class.forName("");
    }

    public static void main(String[] args) throws Exception {
        VeryComplexClass v = new VeryComplexClass();
        v.veryComplexMethod();
    }
}
