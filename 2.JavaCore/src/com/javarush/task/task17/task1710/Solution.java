package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут

        switch (args[0]) {
            case "-c":
                create(args[1], args[2], args[3]);
                break;
            case "-u":
                update(args[1], args[2], args[3], args[4]);
                break;
            case "-d":
                delete(args[1]);
                break;
            case "-i":
                info(args[1]);
                break;
            default:
                System.out.println("Неверные параметры");
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
