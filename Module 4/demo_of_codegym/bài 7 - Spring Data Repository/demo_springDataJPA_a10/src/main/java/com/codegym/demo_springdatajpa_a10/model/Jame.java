package com.codegym.demo_springdatajpa_a10.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Jame {
    @Id
    private String username;
    private String password;

    @OneToOne(mappedBy = "jame")
    private Student student;

    public Jame() {
    }

    public Jame(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
