package repository.impl;

import connections.BaseRepository;
import model.Book;
import repository.IBookRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements IBookRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private List<Book> bookList = new ArrayList<>();

    private String FIND_ALL_BOOK = "select * from book";


    @Override
    public List<Book> find_all_book() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
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
        }finally {
            try {
                resultSet.close();
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            BaseRepository.close();
        }
        return bookList;
    }
}
