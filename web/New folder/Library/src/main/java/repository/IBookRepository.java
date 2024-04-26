package repository;


import model.Book;

import java.util.List;

public interface IBookRepository {
    List<Book> find_all_book();
}
