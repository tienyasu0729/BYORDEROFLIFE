package com.example.quan_ly_sann_pham.repository;

import com.example.quan_ly_sann_pham.model.Category;

import java.util.List;

public interface ICategoryRepository {
    Category findById(String id);
    List<Category> findAll();
}
