package com.javarush.task.task22.task2207;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            List<String> lines = Files.readAllLines(Paths.get(reader.readLine()));
            StringBuilder sb = new StringBuilder();
            for (String line : lines) {
                sb.append(line+ " ");
            }
            String[] strings = sb.toString().split(" ");
            for (int i = 0; i < strings.length; i++) {
                String word = strings[i];
                for (int j = i+1; j < strings.length; j++) {
                    StringBuilder sb2 = new StringBuilder(word);
                    String s = sb2.reverse().toString();
                    if ((s.equals(strings[j])) && (i != j) && (!strings[i].equals("")) && (!strings[j].equals("")) && (!word.equals(""))) {
                        Pair pair = new Pair();
                        pair.first = word;
                        pair.second = strings[j];
                        result.add(pair);
                        strings[i] = "";
                        strings[j] = "";
                        word = "";
                    }
                }
            }
            for (Pair pair : result) {
                System.out.println(pair.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
