package com.javarush.task.task39.task3905;

/* 
Залей меня полностью
*/

import static com.javarush.task.task39.task3905.Color.BLUE;
import static com.javarush.task.task39.task3905.Color.RED;
import static com.javarush.task.task39.task3905.Color.YELLOW;

public class Solution {
    public static void main(String[] args) {
        Color[][] image = new Color[][]{
                {YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, RED},
                {YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, RED, YELLOW},
                {YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, RED, YELLOW, YELLOW},
                {YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, RED, YELLOW, YELLOW, YELLOW},
                {YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, RED, YELLOW, YELLOW, YELLOW, YELLOW},
                {YELLOW, YELLOW, YELLOW, YELLOW, RED, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW},
                {YELLOW, YELLOW, YELLOW, RED, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW},
                {YELLOW, YELLOW, RED, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW},
                {YELLOW, RED, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW},
                {RED, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW}};


        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }

        PhotoPaint photoPaint = new PhotoPaint();
        photoPaint.paintFill(image, 2, 2, BLUE);

        System.out.println("------------------------------------------------------------------");

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }
}