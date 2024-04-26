package com.example.library.service.Impl;

import com.example.library.model.Form_borrow_book;
import com.example.library.repository.impl.List_borrow_bookRepositoryImpl;
import com.example.library.service.IList_borrow_bookService;

import java.util.List;

public class List_borrow_bookServiceImpl implements IList_borrow_bookService {
    private List_borrow_bookRepositoryImpl formBorrowBookService = new List_borrow_bookRepositoryImpl();
    @Override
    public List<Form_borrow_book> display_list_borrow_book() {
        return formBorrowBookService.display_list_borrow_book();
    }

    @Override
    public List<Form_borrow_book> find_list_borrow_book_by_name(String name_book) {
        return formBorrowBookService.find_list_borrow_book_by_name_book(name_book);
    }

    @Override
    public List<Form_borrow_book> find_list_borrow_book_by_name_student(String name_student) {
        return formBorrowBookService.find_list_borrow_book_by_name_student(name_student);
    }
}
