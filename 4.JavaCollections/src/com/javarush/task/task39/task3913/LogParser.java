package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private Path logDir;
    public LogParser(Path logDir) {
        this.logDir = logDir;
    }
    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }
    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return getIpSet(null, after, before);
    }
    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return getIpSet(user, after, before);
    }
    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return getIpSet(event, after, before);
    }
    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return getIpSet(status, after, before);
    }
    @Override
    public Set<String> getAllUsers() {
        Set<String> users = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (!users.contains(record.getUser())) {
                users.add(record.getUser());
            }
        }
        return users;
    }
    @Override
    public int getNumberOfUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && !users.contains(record.getUser())) {
                users.add(record.getUser());
            }
        }
        return users.size();
    }
    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate())) {
                if (record.getUser().equals(user)) set.add(record.getEvent());
            }
        }
        return set.size();
    }
    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && record.getIp().equals(ip)) {
                users.add(record.getUser());
            }
        }
        return users;
    }
    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && record.getEvent().equals(Event.LOGIN)) {
                users.add(record.getUser());
            }
        }
        return users;
    }
    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && record.getEvent().equals(Event.DOWNLOAD_PLUGIN)) {
                users.add(record.getUser());
            }
        }
        return users;
    }
    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && record.getEvent().equals(Event.WRITE_MESSAGE)) {
                users.add(record.getUser());
            }
        }
        return users;
    }
    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && record.getEvent().equals(Event.SOLVE_TASK)) {
                users.add(record.getUser());
            }
        }
        return users;
    }
    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set<String> users = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate())
                    && record.getEvent().equals(Event.SOLVE_TASK)
                    && record.getTaskNumber() != null
                    && !record.getTaskNumber().isEmpty()
                    && Integer.parseInt(record.getTaskNumber()) == task) {
                users.add(record.getUser());
            }
        }
        return users;
    }
    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && record.getEvent().equals(Event.DONE_TASK)) {
                users.add(record.getUser());
            }
        }
        return users;
    }
    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set<String> users = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate())
                    && record.getEvent().equals(Event.DONE_TASK)
                    && record.getTaskNumber() != null
                    && !record.getTaskNumber().isEmpty()
                    && Integer.parseInt(record.getTaskNumber()) == task) {
                users.add(record.getUser());
            }
        }
        return users;
    }
    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && user.equals(record.getUser()) && record.getEvent().equals(event)) {
                dates.add(record.date);
            }
        }
        return dates;
    }
    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && record.getStatus().equals(Status.FAILED)) {
                dates.add(record.date);
            }
        }
        return dates;
    }
    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && record.getStatus().equals(Status.ERROR)) {
                dates.add(record.date);
            }
        }
        return dates;
    }
    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        Date date = null;
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && record.getUser().equals(user) && record.getEvent().equals(Event.LOGIN)) {
                if (date == null) date = record.getDate();
                else date = date.compareTo(record.getDate()) > 0 ? record.getDate() : date;
            }
        }
        return date;
    }
    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        Date date = null;
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate())
                    && record.getUser().equals(user)
                    && record.getEvent().equals(Event.SOLVE_TASK)
                    && record.getTaskNumber() != null
                    && !record.getTaskNumber().isEmpty()
                    && Integer.parseInt(record.getTaskNumber()) == task) {
                if (date == null) date = record.getDate();
                else date = date.compareTo(record.getDate()) > 0 ? record.getDate() : date;
            }
        }
        return date;
    }
    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        Date date = null;
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate())
                    && record.getUser().equals(user)
                    && record.getEvent().equals(Event.DONE_TASK)
                    && record.getTaskNumber() != null
                    && !record.getTaskNumber().isEmpty()
                    && Integer.parseInt(record.getTaskNumber()) == task) {
                if (date == null) date = record.getDate();
                else date = date.compareTo(record.getDate()) > 0 ? record.getDate() : date;
            }
        }
        return date;
    }
    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate())
                    && record.getUser().equals(user)
                    && record.getEvent().equals(Event.WRITE_MESSAGE)) {
                dates.add(record.date);
            }
        }
        return dates;
    }
    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate())
                    && record.getUser().equals(user)
                    && record.getEvent().equals(Event.DOWNLOAD_PLUGIN)) {
                dates.add(record.date);
            }
        }
        return dates;
    }
    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getAllEvents(after, before).size();
    }
    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate())) {
                set.add(record.getEvent());
            }
        }
        return set;
    }
    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && record.getIp().equals(ip)) {
                set.add(record.getEvent());
            }
        }
        return set;
    }
    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && record.getUser().equals(user)) {
                set.add(record.getEvent());
            }
        }
        return set;
    }
    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && record.getStatus().equals(Status.FAILED)) {
                set.add(record.getEvent());
            }
        }
        return set;
    }
    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && record.getStatus().equals(Status.ERROR)) {
                set.add(record.getEvent());
            }
        }
        return set;
    }
    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        int i = 0;
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate())
                    && record.getEvent().equals(Event.SOLVE_TASK)
                    && record.getTaskNumber() != null
                    && !record.getTaskNumber().isEmpty()
                    && Integer.parseInt(record.getTaskNumber()) == task) {
                i++;
            }
        }
        return i;
    }
    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        int i = 0;
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate())
                    && record.getEvent().equals(Event.DONE_TASK)
                    && record.getTaskNumber() != null
                    && !record.getTaskNumber().isEmpty()
                    && Integer.parseInt(record.getTaskNumber()) == task) {
                i++;
            }
        }
        return i;
    }
    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> taskSolved = new HashMap<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && record.getEvent().equals(Event.SOLVE_TASK)) {
                int task = Integer.parseInt(record.getTaskNumber());
                if (taskSolved.containsKey(task)) {
                    taskSolved.put(task, taskSolved.get(task) + 1);
                } else {
                    taskSolved.put(task, 1);
                }
            }
        }
        return taskSolved;
    }
    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> taskSolved = new HashMap<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && record.getEvent().equals(Event.DONE_TASK)) {
                int task = Integer.parseInt(record.getTaskNumber());
                if (taskSolved.containsKey(task)) {
                    taskSolved.put(task, taskSolved.get(task) + 1);
                } else {
                    taskSolved.put(task, 1);
                }
            }
        }
        return taskSolved;
    }
    @Override
    public Set<Object> execute(String query) {
        Set<Object> res = new HashSet<>();
        if (query == null || query.isEmpty()) return res;
        Pattern p = Pattern.compile("get (ip|user|date|event|status)"
                + "( for (ip|user|date|event|status) = \"(.*?)\")?"
                + "( and date between \"(.*?)\" and \"(.*?)\")?");
        Matcher m = p.matcher(query);
        String field1 = null;
        String field2 = null;
        String value1 = null;
        Date dateFrom = null;
        Date dateTo = null;
        if (m.find()) {
            field1 = m.group(1);
            field2 = m.group(3);
            value1 = m.group(4);
            String d1 = m.group(6);
            String d2 = m.group(7);
            try {
                dateFrom = new SimpleDateFormat("d.M.yyyy H:m:s").parse(d1);
            } catch (Exception e) {
                dateFrom = null;
            }
            try {
                dateTo = new SimpleDateFormat("d.M.yyyy H:m:s").parse(d2);
            } catch (Exception e) {
                dateTo = null;
            }
            switch (field1) {
                case "ip": {
                    res.addAll(getAllIps(field2, value1, dateFrom, dateTo));
                    break;
                }
                case "user": {
                    res.addAll(getAllUsers(field2, value1, dateFrom, dateTo));
                    break;
                }
                case "date": {
                    res.addAll(getAllDates(field2, value1, dateFrom, dateTo));
                    break;
                }
                case "event": {
                    res.addAll(getAllEvents(field2, value1, dateFrom, dateTo));
                    break;
                }
                case "status": {
                    res.addAll(getAllStatuses(field2, value1, dateFrom, dateTo));
                    break;
                }
            }
        }
        return res;
    }
    private boolean isFieldMatch(String field, String value, LogRecord record) throws ParseException {
        boolean criteria = false;
        if (field == null) return true;
        if (value == null) return false;
        switch (field) {
            case "ip": {
                criteria = record.getIp().equals(value);
                break;
            }
            case "user": {
                criteria = record.getUser().equals(value);
                break;
            }
            case "date": {
                criteria = record.getDate().equals(new SimpleDateFormat("d.M.yyyy H:m:s").parse(value));
                break;
            }
            case "event": {
                criteria = record.getEvent().equals(Event.valueOf(value));
                break;
            }
            case "status": {
                criteria = record.getStatus().equals(Status.valueOf(value));
                break;
            }
        }
        return criteria;
    }
    private Set<String> getAllIps(String field, String value, Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            try {
                if (isDateInside(after, before, record.getDate()) && isFieldMatch(field, value, record)) {
                    users.add(record.getIp());
                }
            } catch (ParseException e) {
                //e.printStackTrace();
            }
        }
        return users;
    }
    private Set<Date> getAllDates(String field, String value, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            try {
                if (isDateInside(after, before, record.getDate()) && isFieldMatch(field, value, record)) {
                    dates.add(record.date);
                }
            } catch (ParseException e) {
                //e.printStackTrace();
            }
        }
        return dates;
    }
    private Set<Status> getAllStatuses(String field, String value, Date after, Date before) {
        Set<Status> set = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            try {
                if (isDateInside(after, before, record.getDate()) && isFieldMatch(field, value, record)) {
                    set.add(record.getStatus());
                }
            } catch (ParseException e) {
                //e.printStackTrace();
            }
        }
        return set;
    }
    private Set<Event> getAllEvents(String field, String value, Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            try {
                if (isDateInside(after, before, record.getDate()) && isFieldMatch(field, value, record)) {
                    set.add(record.getEvent());
                }
            } catch (ParseException e) {
                //e.printStackTrace();
            }
        }
        return set;
    }
    private Set<String> getAllUsers(String field, String value, Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            try {
                if (isDateInside(after, before, record.getDate()) && isFieldMatch(field, value, record)) {
                    users.add(record.getUser());
                }
            } catch (ParseException e) {
                //e.printStackTrace();
            }
        }
        return users;
    }
    private Set<String> getIpSet(Object recordField, Date after, Date before) {
        Set<String> ipSet = new HashSet<>();
        for (LogRecord record : getParsedRecords(logDir)) {
            if (isDateInside(after, before, record.getDate()) && isFieldMatch(recordField, record)) {
                ipSet.add(record.getIp());
            }
        }
        return ipSet;
    }
    private List<LogRecord> getParsedRecords(Path logDir) {
        List<LogRecord> recordList = new ArrayList<>();
        try {
            for (File file : logDir.toFile().listFiles()) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".log"))
                    for (String record : Files.readAllLines(file.toPath(), Charset.defaultCharset())) {
                        recordList.add(new LogRecord(record));
                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return recordList;
    }
    private boolean isFieldMatch(Object recordField, LogRecord record) {
        boolean criteria = false;
        if (recordField == null)
            return true;
        if (recordField instanceof String)
            criteria = record.getUser().equals(recordField);
        else if (recordField instanceof Event)
            criteria = record.getEvent().equals(recordField);
        else if (recordField instanceof Status)
            criteria = record.getStatus().equals(recordField);
        return criteria;
    }
    private boolean isDateInside(Date after, Date before, Date currentDate) {
        if (after != null) {
            if (currentDate.getTime() <= after.getTime())
                return false;
        }
        if (before != null) {
            if (currentDate.getTime() >= before.getTime())
                return false;
        }
        return true;
    }
    private class LogRecord {
        private String ip;
        private String user;
        private Date date;
        private Event event;
        private String taskNumber;
        private Status status;
        public LogRecord(String ip, String user, Date date, Event event, Status status) {
            this.ip = ip;
            this.user = user;
            this.date = date;
            this.event = event;
            this.status = status;
        }
        public LogRecord(String record) {
            String[] strings = record.split("\t");
            this.ip = strings[0].trim();
            this.user = strings[1];
            SimpleDateFormat dateFormat = new SimpleDateFormat("d.M.yyyy H:m:s");
            try {
                date = dateFormat.parse(strings[2]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String eventAndParameter[] = strings[3].split(" ");
            event = Event.valueOf(eventAndParameter[0]);
            if (eventAndParameter.length > 1) taskNumber = eventAndParameter[1];
            status = Status.valueOf(strings[4]);
        }
        public String getIp() {
            return ip;
        }
        public String getUser() {
            return user;
        }
        public Date getDate() {
            return date;
        }
        public Event getEvent() {
            return event;
        }
        public String getTaskNumber() {
            return taskNumber;
        }
        public Status getStatus() {
            return status;
        }
    }
}

/*
package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private Path logDir;
    private List<EventRow> logData;

    public LogParser(Path logDir) {
        this.logDir = logDir;
        readLogs(logDir);
    }

    private Set<String> getIPSet(String user, Event event, Status status, Date after, Date before) {
        if (logData == null) readLogs(logDir);

        return logData
                .stream()
                .filter(s -> filter(s, null, user, event, status, -1))
                .filter(s -> dateBetween(s.date, after, before))
//                .peek(System.out::println)
                .map(s -> s.ip)
                .collect(Collectors.toSet());
    }

    private boolean dateBetween(Date date, Date after, Date before) {
        return (after == null || date.after(after) || date.equals(after)) &&
                (before == null || date.before(before) || date.equals(before));
    }

    private boolean filter(EventRow row, String ip, String user, Event event, Status status, int task) {
        if (row == null) return false;
        if (ip != null) return row.ip.equalsIgnoreCase(ip);
        else if (user != null) return row.name.equalsIgnoreCase(user);
        else if (event != null) return row.event == event;
        else if (status != null) return row.status == status;
        else if (task != -1) return row.task == task;

        return true;
    }

    private boolean filter(EventRow row, String user, Event event, Status status) {
        if (row == null) return false;
        if (user != null) return row.name.equalsIgnoreCase(user);
        else if (event != null) return row.event == event;
        else if (status != null) return row.status == status;

        return true;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getIPSet(null, null, null, after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return getIPSet(null, null, null, after, before);
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return getIPSet(user, null, null, after, before);
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return getIPSet(null, event, null, after, before);
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return getIPSet(null, null, status, after, before);
    }

    private void readLogs(Path logDir) {
        if (this.logData == null) this.logData = new ArrayList<>();

        try {
            for (Path log : Files.newDirectoryStream(logDir)) {
                if (Files.isRegularFile(log) && log.toString().endsWith(".log")) {
                    logData.addAll(Files
                            .readAllLines(log)
                            .stream()
                            .map(s -> new EventRow(s))
                            .collect(Collectors.toList()));
                } else {
                    if (Files.isDirectory(log)) readLogs(log);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<String> getAllUsers() {
        if (logData == null) readLogs(logDir);

        return logData
                .stream()
                .map(s -> s.name)
                .collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        if (logData == null) readLogs(logDir);

        return logData
                .stream()
                .filter(s -> dateBetween(s.date, after, before))
                .map(s -> s.name)
                .collect(Collectors.toSet()).size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        if (logData == null) readLogs(logDir);

        return logData
                .stream()
                .filter(s -> s.name.equalsIgnoreCase(user))
                .filter(s -> dateBetween(s.date, after, before))
                .map(s -> s.event)
                .collect(Collectors.toSet()).size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        if (logData == null) readLogs(logDir);

        return logData
                .stream()
                .filter(s -> s.ip.equals(ip))
                .filter(s -> dateBetween(s.date, after, before))
                .map(s -> s.name)
                .collect(Collectors.toSet());
    }

    private Set<String> getUsersByEvent(Event event, Date after, Date before, int task) {
        if (logData == null) readLogs(logDir);

        return logData
                .stream()
                .filter(s -> s.event.equals(event))
                .filter(s -> dateBetween(s.date, after, before))
                .filter(s -> {
                    if (s.task == -1 || task == -1) return true;
                    else return s.task == task;
                })
                .map(s -> s.name)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        return getUsersByEvent(Event.LOGIN, after, before, -1);
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return getUsersByEvent(Event.DOWNLOAD_PLUGIN, after, before, -1);
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return getUsersByEvent(Event.WRITE_MESSAGE, after, before, -1);
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return getUsersByEvent(Event.SOLVE_TASK, after, before, -1);
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        return getUsersByEvent(Event.SOLVE_TASK, after, before, task);
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return getUsersByEvent(Event.DONE_TASK, after, before, -1);
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        return getUsersByEvent(Event.DONE_TASK, after, before, task);
    }

    private Set<Date> getDates(String user, Event event, Status status, int task, Date after, Date before) {
        if (logData == null) readLogs(logDir);
        return logData
                .stream()
                .filter(s -> filter(s, null, user, event, status, task))
                .filter(s -> filter(s, null, null, event, status, task))
                .filter(s -> filter(s, null, null, null, status, task))
                .filter(s -> filter(s, null, null, null, null, task))
                .filter(s -> dateBetween(s.date, after, before))
                .map(s -> s.date)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        return getDates(user, event, null, -1, after, before);
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        return getDates(null, null, Status.FAILED, -1, after, before);
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        return getDates(null, null, Status.ERROR, -1, after, before);
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        List<EventRow> preFiltered = logData
                .stream()
                .filter(s -> s.name.equalsIgnoreCase(user))
                .filter(s -> dateBetween(s.date, after, before))
                .sorted((s1, s2) -> (s1.date.compareTo(s2.date)))
                .collect(Collectors.toList());
        Date date = null;
        for (EventRow row : preFiltered) {
            if (row.event == Event.LOGIN) {
                date = row.date;
                break;
            }
        }
        return date;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        List<EventRow> preFiltered = logData
                .stream()
                .filter(s -> s.name.equalsIgnoreCase(user))
                .filter(s -> s.task == task)
                .filter(s -> dateBetween(s.date, after, before))
                .sorted((s1, s2) -> (s1.date.compareTo(s2.date)))
                .collect(Collectors.toList());
        Date date = null;
        for (EventRow row : preFiltered) {
            if (row.event == Event.SOLVE_TASK) {
                date = row.date;
                break;
            }
        }
        return date;
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        List<EventRow> preFiltered = logData
                .stream()
                .filter(s -> s.name.equalsIgnoreCase(user))
                .filter(s -> s.task == task)
                .filter(s -> dateBetween(s.date, after, before))
                .sorted((s1, s2) -> (s1.date.compareTo(s2.date)))
                .collect(Collectors.toList());
        Date date = null;
        for (EventRow row : preFiltered) {
            if (row.event == Event.DONE_TASK) {
                date = row.date;
                break;
            }
        }
        return date;
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        return getDates(user, Event.WRITE_MESSAGE, null, -1, after, before);
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        return getDates(user, Event.DOWNLOAD_PLUGIN, null, -1, after, before);
    }

    private Set<Event> getEvents(String ip, String user, Event event, Status status, int task, Date after, Date before) {
        if (logData == null) readLogs(logDir);
        return logData
                .stream()
                .filter(s -> filter(s, ip, user, event, status, task))
                .filter(s -> filter(s, null, user, event, status, task))
                .filter(s -> filter(s, null, null, event, status, task))
                .filter(s -> filter(s, null, null, null, status, task))
                .filter(s -> filter(s, null, null, null, null, task))
                .filter(s -> dateBetween(s.date, after, before))
                .map(s -> s.event)
                .collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getEvents(null, null, null, null, -1, after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        return getEvents(null, null, null, null, -1, after, before);
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        return getEvents(ip, null, null, null, -1, after, before);
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        return getEvents(null, user, null, null, -1, after, before);
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        return getEvents(null, null, null, Status.FAILED, -1, after, before);
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        return getEvents(null, null, null, Status.ERROR, -1, after, before);
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        return logData
                .stream()
                .filter(s -> dateBetween(s.date, after, before))
                .filter(s -> s.task == task)
                .filter(s -> s.event.equals(Event.SOLVE_TASK))
                .collect(Collectors.toList()).size();
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        return logData
                .stream()
                .filter(s -> dateBetween(s.date, after, before))
                .filter(s -> s.task == task)
                .filter(s -> s.event.equals(Event.DONE_TASK))
//                .filter(s -> s.status.equals(Status.OK))
                .collect(Collectors.toList()).size();
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();
        List<EventRow> list = logData
                .stream()
                .filter(s -> dateBetween(s.date, after, before))
                .filter(s -> s.event.equals(Event.SOLVE_TASK))
//                .filter(s -> s.status.equals(Status.OK))
                .collect(Collectors.toList());

        for (EventRow row : list) {
//            map.computeIfPresent(row.task, (v1, v2) -> (v1 + 1));
            map.putIfAbsent(row.task, getNumberOfAttemptToSolveTask(row.task, after, before));
        }
        return map;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();
        List<EventRow> list = logData
                .stream()
                .filter(s -> dateBetween(s.date, after, before))
                .filter(s -> s.event.equals(Event.DONE_TASK))
//                .filter(s -> s.status.equals(Status.OK))
                .collect(Collectors.toList());

        for (EventRow row : list) {
//            map.computeIfPresent(row.task, (v1, v2) -> (v1 + 1));
            map.putIfAbsent(row.task, getNumberOfSuccessfulAttemptToSolveTask(row.task, after, before));
        }
        return map;
    }

    @Override
    public Set<Object> execute(String query) {
        Set<Object> result = new HashSet<>();
        if (query == null || query.isEmpty()) return result;

        Pattern p = Pattern.compile("get (ip|user|date|event|status)");
//                + "( for (ip|user|date|event|status) = \"(.*?)\")?"
//                + "( and date between \"(.*?)\" and \"(.*?)\")?");

        Matcher m = p.matcher(query);

        String s1 = null;
        String s2 = null;
        String v = null;
        Date after = null;
        Date before = null;

        if (m.find()) {
            s1 = m.group(1);
//            s2 = m.group(3);
//            v = m.group(4);
//            String d1 = m.group(6);
//            String d2 = m.group(7);
//            try {
//                after = new SimpleDateFormat("d.M.yyyy H:m:s").parse(d1);
//            } catch (Exception e) {
//                after = null;
//            }
//            try {
//                before = new SimpleDateFormat("d.M.yyyy H:m:s").parse(d2);
//            } catch (Exception e) {
//                before = null;
//            }

            switch (s1) {
                case "ip": {
                    result.addAll(getUniqueIPs(after, before));
                    break;
//                    switch (s2) {
//                        case "ip" : {
//                            result.addAll(getIPSet(null, s2, v, after, before));
//                            break;
//                        }
//                        case "user" : {
//                            result.addAll(getIPsForUser(v, after, before));
//                            break;
//                        }
//                        case "date" : {
//                            result.addAll(getUniqueIPs(after, before));
//                            break;
//                        }
//                        case "event" : {
//                            result.addAll(getIPsForEvent(Event.valueOf(v), after, before));
//                            break;
//                        }
//                        case "status" : {
//                            result.addAll(getIPsForStatus(Status.valueOf(v), after, before));
//                            break;
//                        }
//                    }
                }
                case "user": {
                    result.addAll(getAllUsers());
                    break;
                }
                case "date": {
                    for (EventRow row : logData) {
                        result.add(row.date);
                    }
                    break;
                }
                case "event": {
                    result.addAll(getAllEvents(after, before));
                    break;
                }
                case "status": {
                    for (EventRow row : logData) {
                        result.add(row.status);
                    }
                    break;
                }
            }
        }
        return result;
    }

    private class EventRow {
        private String ip;
        private String name;
        private Date date;
        private Event event;
        private int task;
        private Status status;

        public EventRow(String logRow) {
            SimpleDateFormat sdf = new SimpleDateFormat();
            sdf.applyPattern("dd.MM.yyyy HH:mm:ss");

            String[] s = logRow.split("\\t");
            ip = s[0];
            name = s[1];
            try {
                date = sdf.parse(s[2]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            event = getEvent(s[3]);
            task = getTask(s[3]);
            status = Status.valueOf(s[4].toUpperCase());
        }

        private Event getEvent(String s) {
            int i;
            String event = s.toUpperCase();
            if ((i = event.indexOf(" ")) > 0) event = event.substring(0, i);
            return Event.valueOf(event);
        }

        private int getTask(String s) {
            int i;
            String task = s.toUpperCase();
            if ((i = task.indexOf(" ")) > 0) return Integer.parseInt(task.substring(i).trim());
            return -1;
        }

        @Override
        public String toString() {
            return "EventRow{" +
                    "ip='" + ip + '\'' +
                    ", name='" + name + '\'' +
                    ", date=" + date +
                    ", event=" + event +
                    ", task=" + task +
                    ", status=" + status +
                    '}';
        }
    }
}*/
