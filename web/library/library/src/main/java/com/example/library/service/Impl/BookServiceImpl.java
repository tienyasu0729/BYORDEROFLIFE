package com.example.library.service.Impl;




import com.example.library.model.Book;
import com.example.library.repository.impl.BookRepositoryImpl;
import com.example.library.service.IBookService;

import java.util.List;

public class BookServiceImpl implements IBookService {
    private BookRepositoryImpl bookRepository = new BookRepositoryImpl();
    @Override
    public List<Book> find_all_book() {
        return bookRepository.find_all_book();
    }

    @Override
    public void check_and_update_quantity(String id_book) {
        bookRepository.check_and_update_quantity(id_book);
    }
}
