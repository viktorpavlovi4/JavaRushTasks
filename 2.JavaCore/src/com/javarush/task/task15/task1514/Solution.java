package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики 1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(0D, "0");
        labels.put(1D, "1");
        labels.put(2D, "2");
        labels.put(3D, "3");
        labels.put(4D, "4");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
