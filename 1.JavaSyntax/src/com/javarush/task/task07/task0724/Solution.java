package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human grand1 = new Human("grand1", true, 77);
        Human grand2 = new Human("grand2", true, 77);
        Human granny1 = new Human("granny1", false, 77);
        Human granny2 = new Human("granny2", false, 77);
        Human father = new Human("father", true, 33, grand1, granny1);
        Human mother = new Human("mother", false, 33, grand2, granny2);
        Human son1 = new Human("son1", true, 15, father, mother);
        Human son2 = new Human("son2", true, 7, father, mother);
        Human son3 = new Human("son3", true, 1, father, mother);

        System.out.println(grand1.toString());
        System.out.println(grand2.toString());
        System.out.println(granny1.toString());
        System.out.println(granny2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(son1.toString());
        System.out.println(son2.toString());
        System.out.println(son3.toString());
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
          this.name = name;
          this.sex = sex;
          this.age = age;
          this.father = father;
          this.mother = mother;
        }


        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















