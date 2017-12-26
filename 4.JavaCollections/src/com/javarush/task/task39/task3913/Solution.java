package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        String log = "c:\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task39\\task3913\\logs";
        LogParser logParser = new LogParser(Paths.get(log));
//        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
//        System.out.println(logParser.getAllUsers());
//        System.out.println(logParser.getNumberOfAttemptToSolveTask(1, null, null));
//        System.out.println(logParser.getNumberOfSuccessfulAttemptToSolveTask(1, null, null));
//        System.out.println(logParser.getAllSolvedTasksAndTheirNumber(null, null));
//        System.out.println(logParser.getAllDoneTasksAndTheirNumber(null, null));
        System.out.println(logParser.execute("get ip for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\""));
//        System.out.println(logParser.execute("get user for event = \"DONE_TASK\""));
//        System.out.println(logParser.execute("get event for date = \"03.01.2014 03:45:23\""));
//        System.out.println(logParser.execute("get event"));
//        System.out.println(logParser.execute("get status"));
    }
}