package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            Person person = null;
            SimpleDateFormat date = new SimpleDateFormat("dd MM yyyy");
            String lastName = fileScanner.next();
            String firstName = fileScanner.next();
            String secondName = fileScanner.next();
            try {
                person = new Person(firstName, secondName, lastName, date.parse(fileScanner.nextInt()+" "+fileScanner.nextInt()+" "+fileScanner.nextInt()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
