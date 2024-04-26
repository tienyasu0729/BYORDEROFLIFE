package com.example.library.model;

public class Student {
    private String id_Student;
    private String name_Student;
    private String class_Student;

    public Student(String id_or_class_Student, String name_Student) {
        this.id_Student = id_or_class_Student;
        this.name_Student = name_Student;
    }

    public Student(String id_Student, String name_Student, String class_Student) {
        this.id_Student = id_Student;
        this.name_Student = name_Student;
        this.class_Student = class_Student;
    }

    public String getId_Student() {
        return id_Student;
    }

    public void setId_Student(String id_Student) {
        this.id_Student = id_Student;
    }

    public String getName_Student() {
        return name_Student;
    }

    public void setName_Student(String name_Student) {
        this.name_Student = name_Student;
    }

    public String getClass_Student() {
        return class_Student;
    }

    public void setClass_Student(String class_Student) {
        this.class_Student = class_Student;
    }
}
