package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<Human> grnd1Children = new ArrayList<>();
        ArrayList<Human> grnd2Children = new ArrayList<>();
        ArrayList<Human> children = new ArrayList<>();

        Human grand1 = new Human("grnd1", true, 77, grnd1Children);
        Human grand2 = new Human("grnd2", true, 77, grnd2Children);
        Human granny1 = new Human("grny1", false, 77, grnd1Children);
        Human granny2 = new Human("grny2", false, 77, grnd2Children);
        Human father = new Human("father", true, 33, children);
        Human mother = new Human("mother", false, 33, children);
        Human child1 = new Human("child1", true, 11);
        Human child2 = new Human("child2", true, 10);
        Human child3 = new Human("child3", true, 13);
        grnd1Children.add(father);
        grnd2Children.add(mother);
        children.add(child1);
        children.add(child2);
        children.add(child3);

        System.out.println(grand1.toString());
        System.out.println(grand2.toString());
        System.out.println(granny1.toString());
        System.out.println(granny2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());

    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
