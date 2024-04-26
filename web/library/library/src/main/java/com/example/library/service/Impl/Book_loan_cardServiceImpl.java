package com.example.library.service.Impl;


import com.example.library.model.Book_loan_card;
import com.example.library.repository.impl.Book_loan_cardRepositoryImpl;
import com.example.library.service.IBook_loan_cardService;

import java.util.List;

public class Book_loan_cardServiceImpl implements IBook_loan_cardService {
    private Book_loan_cardRepositoryImpl book_loan_cardRepository = new Book_loan_cardRepositoryImpl();
    @Override
    public void create_book_loan_card(Book_loan_card book_loan_card) {
        book_loan_cardRepository.create_book_loan_card(book_loan_card);
    }

    @Override
    public Boolean check_id_loan_card(String id_need_check) {
        return book_loan_cardRepository.check_id_loan_card(id_need_check);
    }
}
