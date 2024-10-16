package com.codegym.demo_springdatajpa_a10.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    public int gender;
    @Column(name = "phone_number", nullable = false)
    @Pattern(regexp = "^(03|05|07|08|09)[0-9]{8,9}$", message = "Số điện thoại không hợp lệ, phải bắt đầu bằng đầu số nhà mạng và có 10-11 chữ số.")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "class_id",referencedColumnName = "id")
    private ClassRoom classRoom;

    public Student() {
    }

    public Student(int id, String name, ClassRoom classRoom) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.classRoom = classRoom;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }


    public ClassRoom getClassRoom() {
        return classRoom;
    }
    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

}
