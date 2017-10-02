package com.javarush.task.task14.task1408;

/**
 * Created by XE on 30.04.2017.
 */
public class RussianHen extends Hen {
    public static int i = 10000;
    public int getCountOfEggsPerMonth() { return i;}
    public String getDescription() { return super.getDescription() + " Моя страна - "+ Country.RUSSIA+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";}
}
