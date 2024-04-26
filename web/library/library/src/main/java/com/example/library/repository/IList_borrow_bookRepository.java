package com.example.library.repository;

import com.example.library.model.Form_borrow_book;

import java.util.List;

public interface IList_borrow_bookRepository {
    List<Form_borrow_book> display_list_borrow_book();
    List<Form_borrow_book> find_list_borrow_book_by_name_book(String name_book);
    List<Form_borrow_book> find_list_borrow_book_by_name_student(String name_student);

}
