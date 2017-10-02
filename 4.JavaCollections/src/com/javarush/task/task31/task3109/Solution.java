package com.javarush.task.task31.task3109;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        File file = new File(Paths.get(fileName).toAbsolutePath().toString());
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(file);) {
            properties.loadFromXML(fis);
            fis.close();
        } catch (Exception e) {
            try (FileInputStream fis = new FileInputStream(file);) {
                properties.load(fis);
                fis.close();
            } catch (Exception ex) {
                return properties;
            }
        }
        return properties;
    }
}
