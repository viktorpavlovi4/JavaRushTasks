package com.javarush.test.level03.lesson06.task01;

/* Мама мыла раму
Вывести на экран все возможные комбинации слов «Мама», «Мыла», «Раму».
Подсказка: их 6 штук. Каждую комбинацию вывести с новой строки. Слова не разделять. Пример:
МылаРамуМама
РамуМамаМыла
...
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        String q = "Мама";
        String w = "Мыла";
        String e = "Раму";
        System.out.println(q+w+e);
        System.out.println(q+e+w);
        System.out.println(w+q+e);
        System.out.println(w+e+q);
        System.out.println(e+q+w);
        System.out.println(e+w+q);

    }
}