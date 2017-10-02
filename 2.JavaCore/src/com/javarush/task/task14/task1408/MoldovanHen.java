package com.javarush.task.task14.task1408;

import com.javarush.task.task14.task1408.Solution.*;
/**
 * Created by XE on 30.04.2017.
 */

public class MoldovanHen extends Hen {
    public static int i = 10;
    public int getCountOfEggsPerMonth() { return i;}
    public String getDescription() { return super.getDescription() + " Моя страна - "+ Country.MOLDOVA+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";}
}
