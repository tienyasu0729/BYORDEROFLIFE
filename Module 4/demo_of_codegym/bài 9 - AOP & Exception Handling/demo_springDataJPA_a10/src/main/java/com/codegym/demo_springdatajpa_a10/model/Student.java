package com.codegym.demo_springdatajpa_a10.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    public int gender;

    @OneToOne()
    @JoinColumn(name = "username", referencedColumnName = "username",unique = true)
    private Jame jame;

    @ManyToOne
    @JoinColumn(name = "class_id",referencedColumnName = "id")
    private ClassRoom classRoom;

    @ManyToMany
    @JoinTable(name = "student_subject")
    @JoinColumn(columnDefinition ="student_id",referencedColumnName = "subject_id")
    private Set<Subject> subjectSet;

    public Student() {
    }

    public Student(int id, String name, int gender, Jame jame, ClassRoom classRoom, Set<Subject> subjectSet) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.jame = jame;
        this.classRoom = classRoom;
        this.subjectSet = subjectSet;
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

    public Jame getJame() {
        return jame;
    }

    public void setJame(Jame jame) {
        this.jame = jame;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public Set<Subject> getSubjectSet() {
        return subjectSet;
    }

    public void setSubjectSet(Set<Subject> subjectSet) {
        this.subjectSet = subjectSet;
    }
}
