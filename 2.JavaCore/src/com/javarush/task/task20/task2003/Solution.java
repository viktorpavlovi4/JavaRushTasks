package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f = reader.readLine();
        FileInputStream fis = new FileInputStream(f);
        reader.close();
        load(fis);
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties myProperties = new Properties();
//        for (Map.Entry<String, String> entry : properties.entrySet()) {
//            myProperties.setProperty(entry.getKey().toString(),entry.getValue().toString());
//        }
        myProperties.putAll(properties);
        myProperties.store(outputStream,"!!!!!");
        outputStream.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties myProperties = new Properties();
        myProperties.load(inputStream);
        properties.clear();
        for (Map.Entry<Object, Object> entry : myProperties.entrySet()) {
            properties.put(entry.getKey().toString(), entry.getValue().toString());
        }
        inputStream.close();
    }

    public static void main(String[] args) {
    }
}
