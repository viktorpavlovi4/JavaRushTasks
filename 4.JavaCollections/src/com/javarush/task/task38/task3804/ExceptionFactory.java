package com.javarush.task.task38.task3804;

public class ExceptionFactory {
    public static Throwable getException(Enum e) {
        if (e != null) {
            String s = e.name().charAt(0) + e.name().substring(1).toLowerCase().replaceAll("_", " ");

            if (e instanceof ExceptionApplicationMessage)
                return new Exception(s);
            else if (e instanceof ExceptionDBMessage)
                return new RuntimeException(s);
            else if (e instanceof ExceptionUserMessage)
                return new Error(s);
        }
        return new IllegalArgumentException();
    }
}
