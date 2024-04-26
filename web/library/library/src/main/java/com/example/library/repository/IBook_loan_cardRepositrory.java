package com.example.library.repository;

import com.example.library.model.Book_loan_card;
import com.example.library.model.Form_borrow_book;

import java.util.List;

public interface IBook_loan_cardRepositrory {
    void create_book_loan_card(Book_loan_card book_loan_card);
    Boolean check_id_loan_card(String id_need_check);
}
