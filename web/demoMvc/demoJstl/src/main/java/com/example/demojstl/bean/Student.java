package com.example.demojstl.bean;

public class Student {
    private String id;
    private String name;
    private int sex;
    private String address;
    private float mark;

    public Student() {
    }

    public Student(String id, String name, int sex, String address, float mark) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.mark = mark;
    }

    public Student(String id, String name, int sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.address = "";
        this.mark = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }
}
