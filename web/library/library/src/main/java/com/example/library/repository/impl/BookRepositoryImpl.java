package com.example.library.repository.impl;


import com.example.library.connections.BaseRepository;
import com.example.library.model.Book;
import com.example.library.repository.IBookRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements IBookRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private String FIND_ALL_BOOK = "select * from book";
    private String CHECK_QUANTITY_BOOK = "SELECT quantity_book FROM book WHERE id_book = ?";
    private String UPDATE_QUANTITY_BOOK = "UPDATE book SET quantity_book = ? WHERE id_book = ?";

    @Override
    public void check_and_update_quantity(String id_book) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(CHECK_QUANTITY_BOOK);
            preparedStatement.setString(1, id_book);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int quantity_book = resultSet.getInt("quantity_book");
            if (quantity_book > 0){
                PreparedStatement preparedStatement1 = this.baseRepository.getConnectionJavaToDB().prepareStatement(UPDATE_QUANTITY_BOOK);
                preparedStatement1.setInt(1, quantity_book - 1);
                preparedStatement1.setString(2,id_book);
                preparedStatement1.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Book> find_all_book() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Book> bookList = new ArrayList<>();
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(FIND_ALL_BOOK);
            resultSet = preparedStatement.executeQuery();

            Book book = null;
            while (resultSet.next()){
                String id_book = resultSet.getString("id_book");
                String name_book = resultSet.getString("name_book");
                String author_book = resultSet.getString("author_book");
                String describe_book = resultSet.getString("describe_book");
                int quantity_book = Integer.parseInt(resultSet.getString("quantity_book"));
                book = new Book(id_book,name_book,author_book,describe_book,quantity_book);
                bookList.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookList;
    }
}
