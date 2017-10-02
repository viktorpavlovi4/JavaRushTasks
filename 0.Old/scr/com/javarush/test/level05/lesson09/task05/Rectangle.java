package com.javarush.test.level05.lesson09.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше конструкторов:
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle {
    private int top;
    private int left;
    private int width = 0;
    private int height = width;

    public Rectangle(int top, int left, int width, int height){
        this.top = top + left + width + height;
    }
    public Rectangle(int top, int left){
        this.top = top + left + width + height;
    }
    public Rectangle(int top, int left, int width){
        this.top = top + left + width + height;
    }
    public Rectangle (Rectangle rectangle){
        this.top = rectangle.top + rectangle.left + rectangle.width + rectangle.height;
    }
}
