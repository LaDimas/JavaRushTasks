package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University  {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age)
    {
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

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        Student result = null;
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade){
                result = student;
            }
        }
        return result;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        int maxIndex = 0;
        double max = students.get(0).getAverageGrade();
        for (int i = 1; i < students.size(); i ++){
            if (students.get(i).getAverageGrade() > max){
                max = students.get(i).getAverageGrade();
                maxIndex = i;
            }
        }
        return students.get(maxIndex);
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        int minIndex = 0;
        double min = students.get(0).getAverageGrade();
        for (int i = 1; i < students.size(); i ++){
            if (students.get(i).getAverageGrade() < min){
                min = students.get(i).getAverageGrade();
                minIndex = i;
            }
        }
        return students.get(minIndex);
    }

    public void  expel(Student student){
        students.remove(student);
    }
}