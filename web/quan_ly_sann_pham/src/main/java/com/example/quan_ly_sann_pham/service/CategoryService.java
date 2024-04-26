package com.example.quan_ly_sann_pham.service;

import com.example.quan_ly_sann_pham.model.Category;

import java.util.List;

public interface CategoryService {
    Category findById(String id);
    List<Category> findAll();
}
