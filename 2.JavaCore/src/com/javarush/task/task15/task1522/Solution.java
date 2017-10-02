package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем Singleton pattern
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = br.readLine();
            if (s.equals(Planet.EARTH))
                thePlanet = Earth.getInstance();
            else if (s.equals(Planet.MOON))
                thePlanet = Moon.getInstance();
            else if (s.equals(Planet.SUN))
                thePlanet = Sun.getInstance();
            else
                thePlanet = null;
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}