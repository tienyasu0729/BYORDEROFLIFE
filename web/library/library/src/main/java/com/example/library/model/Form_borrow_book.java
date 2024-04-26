package com.example.library.model;

public class Form_borrow_book {
    private Book_loan_card book_loan_card;
    private Book book;
    private Student student;

    public Form_borrow_book(Book_loan_card book_loan_card, Book book, Student student) {
        this.book_loan_card = book_loan_card;
        this.book = book;
        this.student = student;
    }

    public Book_loan_card getBook_loan_card() {
        return book_loan_card;
    }

    public void setBook_loan_card(Book_loan_card book_loan_card) {
        this.book_loan_card = book_loan_card;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
