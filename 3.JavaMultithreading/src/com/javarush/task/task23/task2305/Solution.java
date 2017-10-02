package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution solution0 = new Solution();
        solution0.innerClasses[0] = solution0.new InnerClass();
        solution0.innerClasses[1] = solution0.new InnerClass();
        Solution solution1 = new Solution();
        solution1.innerClasses[0] = solution1.new InnerClass();
        solution1.innerClasses[1] = solution1.new InnerClass();
        Solution[] solutions = {solution0, solution1};
        return solutions;
    }

    public static void main(String[] args) {

    }
}
