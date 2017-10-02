package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        if (args[0].equals("-u")) {
                updateProduct(args[1], args[2], args[3], args[4], fileName);
            }
        if (args[0].equals("-d")) {
                deleteProduct(args[1], fileName);
            }
        }

    private static void updateProduct(String id, String productName, String price, String quantity, String fileName) throws IOException {
        if (productName.length() > 30) productName = productName.substring(0,30);
        else {
            while (productName.length() < 30) productName = productName+" ";
        }
        while (price.length() < 8) price = price+" ";
        while (quantity.length() < 4) quantity = quantity+" ";
        while (id.length() < 8) id = id+" ";

        BufferedReader fis =new BufferedReader(new FileReader(fileName));
        List<String> all = new ArrayList<>();

        while (fis.ready()) {
            String s = fis.readLine();
            if (s.substring(0,8).equals(id))
                s = id+productName+price+quantity;
            all.add(s);
        }
        fis.close();

        BufferedWriter fos = new BufferedWriter(new FileWriter(fileName));
        for (String s : all)
            fos.write (s+System.getProperty("line.separator"));
        fos.close();
    }

    private static void deleteProduct(String id, String fileName) throws IOException {
        id = id.trim();
        BufferedReader fis = new BufferedReader(new FileReader(fileName));
        List<String> all = new ArrayList<>();
        while (fis.ready()) {
            String s = fis.readLine();
            if (s.substring(0, 8).trim().equals(id))
                ;
            else all.add(s);
        }
        fis.close();
        BufferedWriter fos = new BufferedWriter(new FileWriter(fileName));
        for (String sq : all) {
            fos.write(sq + System.getProperty("line.separator"));
        }
        fos.close();
    }
}
