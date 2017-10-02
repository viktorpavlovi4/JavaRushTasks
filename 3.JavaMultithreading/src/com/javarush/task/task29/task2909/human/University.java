package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    String name;
    int age;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double grade) {
        for (Student student : students) {
            if (student.getAverageGrade() == grade)
                return student;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student student = null;
        double averageGrade = Double.MIN_VALUE;
        for (Student student1 : students) {
            double averageGrade1 = student1.getAverageGrade();
            if (averageGrade1 > averageGrade) {
                averageGrade = averageGrade1;
                student = student1;
            }
        }
        return student;
    }

    public Student getStudentWithMinAverageGrade() {
        Student student = null;
        double averageGrade = Double.MAX_VALUE;
        for (Student student1 : students) {
            double averageGrade1 = student1.getAverageGrade();
            if (averageGrade1 < averageGrade) {
                averageGrade = averageGrade1;
                student = student1;
            }
        }
        return student;
    }

    public void expel(Student student) {
        students.remove(student);
    }
}