package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();

        map.put("Романов", "Роман");
        map.put("Романов", "Рамон");
        map.put("Борисов", "Борис");
        map.put("Ельцин", "Борис");
        map.put("Коловрат", "Евпатий");
        map.put("Ленин", "Володя");
        map.put("Сталин", "Ёся");
        map.put("Джугашвили", "Шпили-вили");
        map.put("Куча", "Такаши");
        map.put("Наши", "Неваши");

        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
