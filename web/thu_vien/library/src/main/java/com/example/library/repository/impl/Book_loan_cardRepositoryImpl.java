package com.example.library.repository.impl;


import com.example.library.connections.BaseRepository;
import com.example.library.model.Book_loan_card;
import com.example.library.repository.IBook_loan_cardRepositrory;
import com.example.library.service.Impl.BookServiceImpl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Book_loan_cardRepositoryImpl implements IBook_loan_cardRepositrory {
    private BaseRepository baseRepository = new BaseRepository();
    private BookServiceImpl bookService = new BookServiceImpl();
    private String CHECK_ID_LOAN_CARD = "select id_loan_card from book_loan_card";
    private String CREATE_BOOK_LOAN_CARD = "INSERT into book_loan_card(id_loan_card, id_book, id_student, status_loan_card, borrowed_date, return_date) values (?,?,?,?,?,?)";
    private String DELETE_BOOK_LOAN_CARD = "DELETE from book_loan_card WHERE id_loan_card = ?";
    private String TAKE_ID_BOOK_FORM_BOOK_LOAN_CARD = "SELECT id_book from book_loan_card where id_loan_card = ?";
    @Override
    public void return_book_borrow(String id_loan_card) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(TAKE_ID_BOOK_FORM_BOOK_LOAN_CARD);
            preparedStatement.setString(1, id_loan_card);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String id_book = resultSet.getString("id_book");

            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(DELETE_BOOK_LOAN_CARD);
            preparedStatement.setString(1, id_loan_card);
            preparedStatement.executeUpdate();
            bookService.check_and_update_quantity(id_book,1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean check_id_loan_card(String id_need_check) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(CHECK_ID_LOAN_CARD);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("id_loan_card");
                if (id_need_check.equals(id)){
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public void create_book_loan_card(Book_loan_card book_loan_card) {
        int status_loan_card = 0;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(CREATE_BOOK_LOAN_CARD);
            preparedStatement.setString(1, book_loan_card.getId_loan_card());
            preparedStatement.setString(2, book_loan_card.getId_book());
            preparedStatement.setString(3, book_loan_card.getId_student());

            // Chuyển đổi boolean trong status book_loan_card thành kiểu bit trong mySQL
            if (book_loan_card.isStatus_loan_card()){
                status_loan_card = 1;
            }
            preparedStatement.setInt(4, status_loan_card);

            preparedStatement.setDate(5, new Date(book_loan_card.getBorrowed_date().getTime()));
            preparedStatement.setDate(6, new Date(book_loan_card.getReturn_date().getTime()));
            bookService.check_and_update_quantity(book_loan_card.getId_book(), -1);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
