package com.javarush.task.task40.task4004;

import java.util.ArrayList;
import java.util.List;

/* 
Принадлежность точки многоугольнику
*/

class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public static void main(String[] args) {
        List<Point> polygon = new ArrayList<>();
        polygon.add(new Point(0, 0));
        polygon.add(new Point(0, 10));
        polygon.add(new Point(10, 10));
        polygon.add(new Point(10, 0));

        System.out.println(isPointInPolygon(new Point(5, 5), polygon));
        System.out.println(isPointInPolygon(new Point(100, 100), polygon));
    }

    public static boolean isPointInPolygon(Point point, List<Point> polygon) {
        int npol = polygon.size();
        Point[] points = polygon.toArray(new Point[0]);
        int j = npol - 1;
        boolean res = false;
        for (int i = 0; i < npol; i++) {
            if (
                    (
                    ((points[i].y <= point.y) && (point.y < points[j].y))
                    || ((points[j].y <= point.y) && (point.y < points[i].y))
                    )
                    && (point.x > (points[j].x - points[i].x) * (point.y - points[i].y) / (points[j].y - points[i].y) +points[i].x)
                    ) {
                res = !res;
            }
            j = i;
        }
        return res;
    }

}

