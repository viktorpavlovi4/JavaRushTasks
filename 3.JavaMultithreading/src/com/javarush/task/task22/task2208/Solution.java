package com.javarush.task.task22.task2208;

import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getValue() != null) {
                if (sb.toString().equals(""))
                sb.append(entry.getKey()).append(" = '").append(entry.getValue()).append("'");
                else
                    sb.append(" and ").append(entry.getKey()).append(" = '").append(entry.getValue()).append("'");
            }
        }
        return sb.toString();
    }
}
