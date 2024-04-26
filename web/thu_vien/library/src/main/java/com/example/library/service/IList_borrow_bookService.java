package com.example.library.service;

import com.example.library.model.Form_borrow_book;

import java.util.List;

public interface IList_borrow_bookService {
    List<Form_borrow_book> display_list_borrow_book();
    List<Form_borrow_book> find_list_borrow_book_by_name(String name_book);
    List<Form_borrow_book> find_list_borrow_book_by_name_student(String name_student);

}
