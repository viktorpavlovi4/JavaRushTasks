package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

/*
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        /*
        //Solution #0
        try {
            Collections.EMPTY_LIST.getClass().getDeclaredClasses().getClass();
            return Class.forName("java.util.Collections$EmptyList");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
        */

        /*
        //Solution #1
        Class[] classes = Collections.class.getDeclaredClasses();
        for (Class clazz : classes) {
            if (
                    List.class.isAssignableFrom(clazz) &&
                            Modifier.isPrivate(clazz.getModifiers()) &&
                            Modifier.isStatic(clazz.getModifiers())
                    ) {
                Method method = Arrays
                        .stream(clazz.getDeclaredMethods())
                        .filter(item ->
                                Objects.equals("get", item.getName()) &&
                                        item.getParameterCount() == 1 &&
                                        Objects.equals(item.getParameterTypes()[0].getSimpleName(), "int")
                        )
                        .findFirst()
                        .orElse(null);

                if (method != null) {
                    try {
                        Constructor constructor = clazz.getDeclaredConstructor();
                        constructor.setAccessible(true);
                        method.setAccessible(true);
                        method.invoke(constructor.newInstance(), 0);
                    } catch (IndexOutOfBoundsException exception) {
                        return clazz;
                    } catch (InvocationTargetException exception) {
                        if (Objects.equals(
                                "IndexOutOfBoundsException",
                                exception.getCause().getClass().getSimpleName()
                        )) {
                            return clazz;
                        }
                    } catch (Exception ignored) {
                    }
                }
            }
        }
        return null;
    }
    */

        //Solution #2
        Class<?>[] arrayOfClasses = Collections.class.getDeclaredClasses();
        for (Class<?> clazz : arrayOfClasses) {
            Class superClazz = clazz.getSuperclass();
            ArrayList<Class> arrayOfSuperClasses = new ArrayList<>();
            while (superClazz != null) {
                arrayOfSuperClasses.add(superClazz);
                superClazz = superClazz.getSuperclass();
            }
            for (Class item : arrayOfSuperClasses) {
                Class<?>[] arrayOfInterfaces = item.getInterfaces();
                for (Class<?> declaredInterface : arrayOfInterfaces) {
                    if (declaredInterface.getSimpleName().equals("List")) {
                        Method[] methods = clazz.getMethods();
                        for (Method method : methods) {
                            if (method.getName().equals("get")) {
                                try {
                                    Constructor<?> constructor = clazz.getDeclaredConstructor();
                                    constructor.setAccessible(true);
                                    List<?> emptyList = (List<?>) constructor.newInstance();
                                    emptyList.get(0);
                                } catch (IndexOutOfBoundsException e) {
                                    return clazz;
                                } catch (Exception e) {
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

}