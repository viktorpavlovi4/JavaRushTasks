package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        while (reader.ready()) {
            String s = reader.readLine();
            String name = s.toString().replaceAll("\\d", "").trim();
            String date = s.split(name+" ")[1];
//            System.out.println(name);
//            System.out.println(date);
            Date date1 = new SimpleDateFormat("dd MM yyyy").parse(date);
            Person person = new Person(name, date1);
            PEOPLE.add(person);
        }
        reader.close();
/*
        for (Person person : PEOPLE) {
            System.out.println(person.getName()+ " " + person.getBirthday());
        }*/
    }
}
