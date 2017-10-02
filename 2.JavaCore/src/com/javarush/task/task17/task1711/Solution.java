package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        create(args[i], args[i+1], args[i+2]);
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {
                        update(args[i], args[i+1], args[i+2], args[i+3]);
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        delete(args[i]);
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        info(args[i]);
                    }
                }
                break;
            default:
                synchronized (allPeople) {
                    System.out.println("Неверные параметры");
                }
                break;
        }
    }

    public static void create(String name, String sex, String bd) {
        SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        try {
            Date BD = formatterIn.parse(bd);
            Sex sexx;
            if (sex.equals("м"))
                allPeople.add(Person.createMale(name, BD));
            else
                allPeople.add(Person.createFemale(name, BD));
            System.out.println(allPeople.size()-1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void update(String id, String name, String sex, String bd) {
        allPeople.get(Integer.parseInt(id)).setName(name);

        Sex sexx;
        if (sex.equals("м"))
            sexx = Sex.MALE;
        else
            sexx = Sex.FEMALE;
        allPeople.get(Integer.parseInt(id)).setSex(sexx);

        SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        try {
            Date BD = formatterIn.parse(bd);
            allPeople.get(Integer.parseInt(id)).setBirthDay(BD);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void delete(String id) {
        allPeople.get(Integer.parseInt(id)).setName(null);
        allPeople.get(Integer.parseInt(id)).setSex(null);
        allPeople.get(Integer.parseInt(id)).setBirthDay(null);
    }

    public static void info(String id) {
        String name = allPeople.get(Integer.parseInt(id)).getName();
        Sex sex = allPeople.get(Integer.parseInt(id)).getSex();
        Date bd = allPeople.get(Integer.parseInt(id)).getBirthDay();

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String BD = formatter.format(bd);

        String sexx = null;
        if (sex.equals(Sex.FEMALE))
            sexx = "ж";
        else if (sex.equals(Sex.MALE))
            sexx = "м";

        System.out.println(name +" " + sexx + " " + BD);
    }
}
