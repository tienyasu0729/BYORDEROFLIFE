package com.example.library.model;

import java.util.Date;

public class Book_loan_card {
    private String id_loan_card;
    private String id_book;
    private String id_student;
    private boolean status_loan_card;
    private Date borrowed_date;
    private Date return_date;

    public Book_loan_card(String id_loan_card) {
        this.id_loan_card = id_loan_card;
    }

    public Book_loan_card(String id_loan_card, Date borrowed_date, Date return_date) {
        this.id_loan_card = id_loan_card;
        this.borrowed_date = borrowed_date;
        this.return_date = return_date;
    }

    public Book_loan_card(String id_loan_card, String id_book, String id_student, boolean status_loan_card, Date borrowed_date, Date return_date) {
        this.id_loan_card = id_loan_card;
        this.id_book = id_book;
        this.id_student = id_student;
        this.status_loan_card = status_loan_card;
        this.borrowed_date = borrowed_date;
        this.return_date = return_date;
    }

    public String getId_loan_card() {
        return id_loan_card;
    }

    public void setId_loan_card(String id_loan_card) {
        this.id_loan_card = id_loan_card;
    }

    public String getId_book() {
        return id_book;
    }

    public void setId_book(String id_book) {
        this.id_book = id_book;
    }

    public String getId_student() {
        return id_student;
    }

    public void setId_student(String id_student) {
        this.id_student = id_student;
    }

    public boolean isStatus_loan_card() {
        return status_loan_card;
    }

    public void setStatus_loan_card(boolean status_loan_card) {
        this.status_loan_card = status_loan_card;
    }

    public Date getBorrowed_date() {
        return borrowed_date;
    }

    public void setBorrowed_date(Date borrowed_date) {
        this.borrowed_date = borrowed_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }
}
