package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        reader.close();

        BufferedReader br1 = new BufferedReader(new FileReader(f1));
        BufferedReader br2 = new BufferedReader(new FileReader(f2));

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        
        while (br1.ready())
            list1.add(br1.readLine());
        while (br2.ready())
            list2.add(br2.readLine());
        br2.close();
        br1.close();

        int i = 0;
        while (list1.size() > i) {
            if (list2.size() == i) {
                lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                list1.remove(i);
            }
            else if (list1.get(i).equalsIgnoreCase(list2.get(i))) {
                lines.add(new LineItem(Type.SAME, list1.get(i)));
                list1.remove(i);
                list2.remove(i);
            }
            else if (list1.get(i).equalsIgnoreCase(list2.get(i+1))) {
                lines.add(new LineItem(Type.ADDED, list2.get(i)));
                list2.remove(i);
            }
            else if (!list1.get(i).equalsIgnoreCase(list2.get(i))) {
                lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                list1.remove(i);
            }
            if (list1.size() == 0 && list2.size() > 0) {
                for (int j = 0; j < list2.size(); j++) {
                    lines.add(new LineItem(Type.ADDED, list2.get(j)));
                    list2.remove(j);
                }
            }
        }

        for (LineItem line : lines) {
            System.out.println(line.type +" "+ line.line);
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
