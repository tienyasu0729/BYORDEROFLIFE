package com.example.test_many_to_many.model;

import java.time.LocalDateTime;
import java.util.Date;

public class User {
    private int idUser;
    private String fullName;
    private String code;
    private Date birthdate;
    private LocalDateTime timeBuild;

    public User(int idUser, String fullName, String code, Date birthdate, LocalDateTime timeBuild) {
        this.idUser = idUser;
        this.fullName = fullName;
        this.code = code;
        this.birthdate = birthdate;
        this.timeBuild = timeBuild;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public LocalDateTime getTimeBuild() {
        return timeBuild;
    }

    public void setTimeBuild(LocalDateTime timeBuild) {
        this.timeBuild = timeBuild;
    }
}
