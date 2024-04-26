package service.Impl;


import model.Book;
import repository.impl.BookRepositoryImpl;
import service.IBookService;

import java.util.List;

public class IBookServiceImpl implements IBookService {
    private BookRepositoryImpl bookRepository = new BookRepositoryImpl();
    @Override
    public List<Book> find_all_book() {
        return bookRepository.find_all_book();
    }
}
