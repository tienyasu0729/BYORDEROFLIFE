package com.example.library.repository.impl;

import com.example.library.connections.BaseRepository;
import com.example.library.model.Book;
import com.example.library.model.Book_loan_card;
import com.example.library.model.Form_borrow_book;
import com.example.library.model.Student;
import com.example.library.repository.IList_borrow_bookRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class List_borrow_bookRepositoryImpl implements IList_borrow_bookRepository {
    private BaseRepository baseRepository = new BaseRepository();

    private String DISPLAY_LIST_BORROW_BOOK = "SELECT blc.id_loan_card, b.name_book, b.author_book, s.name_student, s.class_student, blc.borrowed_date, blc.return_date FROM book_loan_card blc JOIN book b ON blc.id_book = b.id_book JOIN student s ON blc.id_student = s.id_student";
    private String FIND_LIST_BORROW_BOOK_BY_NAME_BOOK = "SELECT blc.id_loan_card, b.name_book, b.author_book, s.name_student, s.class_student, blc.borrowed_date, blc.return_date FROM book_loan_card blc JOIN book b ON blc.id_book = b.id_book JOIN student s ON blc.id_student = s.id_student WHERE b.name_book LIKE ?";
    private String FIND_LIST_BORROW_BOOK_BY_NAME_STUDENT = "SELECT blc.id_loan_card, b.name_book, b.author_book, s.name_student, s.class_student, blc.borrowed_date, blc.return_date FROM book_loan_card blc JOIN book b ON blc.id_book = b.id_book JOIN student s ON blc.id_student = s.id_student WHERE s.name_student LIKE ?";

    @Override
    public List<Form_borrow_book> find_list_borrow_book_by_name_student(String name_student_like) {
        List<Form_borrow_book> borrowBookList = new ArrayList<>();
        Book book = null;
        Student student = null;
        Book_loan_card book_loan_card = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(FIND_LIST_BORROW_BOOK_BY_NAME_STUDENT);
            preparedStatement.setString(1, name_student_like + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id_loan_card = resultSet.getString("id_loan_card");
                String name_book = resultSet.getString("name_book");
                String author_book = resultSet.getString("author_book");
                String name_student = resultSet.getString("name_student");
                String class_student = resultSet.getString("class_student");
                Date borrowed_date = new Date(resultSet.getDate("borrowed_date").getTime());
                Date return_date = new Date(resultSet.getDate("return_date").getTime());
                book = new Book(name_book,author_book);
                student = new Student(class_student,name_student);
                book_loan_card = new Book_loan_card(id_loan_card,borrowed_date,return_date);
                borrowBookList.add(new Form_borrow_book(book_loan_card,book,student));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return borrowBookList;    }

    @Override
    public List<Form_borrow_book> find_list_borrow_book_by_name_book(String name_book_like) {
        List<Form_borrow_book> borrowBookList = new ArrayList<>();
        Book book = null;
        Student student = null;
        Book_loan_card book_loan_card = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(FIND_LIST_BORROW_BOOK_BY_NAME_BOOK);
            preparedStatement.setString(1, name_book_like + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id_loan_card = resultSet.getString("id_loan_card");
                String name_book = resultSet.getString("name_book");
                String author_book = resultSet.getString("author_book");
                String name_student = resultSet.getString("name_student");
                String class_student = resultSet.getString("class_student");
                Date borrowed_date = new Date(resultSet.getDate("borrowed_date").getTime());
                Date return_date = new Date(resultSet.getDate("return_date").getTime());
                book = new Book(name_book,author_book);
                student = new Student(class_student,name_student);
                book_loan_card = new Book_loan_card(id_loan_card,borrowed_date,return_date);
                borrowBookList.add(new Form_borrow_book(book_loan_card,book,student));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return borrowBookList;
    }

    @Override
    public List<Form_borrow_book> display_list_borrow_book() {
        List<Form_borrow_book> borrowBookList = new ArrayList<>();
        Book book = null;
        Student student = null;
        Book_loan_card book_loan_card = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(DISPLAY_LIST_BORROW_BOOK);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id_loan_card = resultSet.getString("id_loan_card");
                String name_book = resultSet.getString("name_book");
                String author_book = resultSet.getString("author_book");
                String name_student = resultSet.getString("name_student");
                String class_student = resultSet.getString("class_student");
                Date borrowed_date = new Date(resultSet.getDate("borrowed_date").getTime());
                Date return_date = new Date(resultSet.getDate("return_date").getTime());
                book = new Book(name_book,author_book);
                student = new Student(class_student,name_student);
                book_loan_card = new Book_loan_card(id_loan_card,borrowed_date,return_date);
                borrowBookList.add(new Form_borrow_book(book_loan_card,book,student));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return borrowBookList;
    }
}
