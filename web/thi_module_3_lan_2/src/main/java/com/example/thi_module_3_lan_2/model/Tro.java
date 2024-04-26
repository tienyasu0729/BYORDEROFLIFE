package com.example.thi_module_3_lan_2.model;

import java.util.Date;

public class Tro {
    private String idTro;
    private String name;
    private String phoneNumber;
    private Date startDate;
    private int idType;
    private String nameType;
    private String note;

    public Tro(String idTro, String name, String phoneNumber, Date startDate, String nameType, String note) {
        this.idTro = idTro;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.startDate = startDate;
        this.nameType = nameType;
        this.note = note;
    }

    public Tro(String idTro, String name, String phoneNumber, Date startDate, int idType, String note) {
        this.idTro = idTro;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.startDate = startDate;
        this.idType = idType;
        this.note = note;
    }

    public String getIdTro() {
        return idTro;
    }

    public void setIdTro(String idTro) {
        this.idTro = idTro;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
