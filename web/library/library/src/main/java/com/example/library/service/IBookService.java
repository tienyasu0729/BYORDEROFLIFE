package com.example.library.service;


import com.example.library.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> find_all_book();
    void check_and_update_quantity(String id_book);

}
