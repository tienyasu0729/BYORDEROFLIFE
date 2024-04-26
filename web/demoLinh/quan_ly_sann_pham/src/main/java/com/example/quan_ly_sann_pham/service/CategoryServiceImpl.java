package com.example.quan_ly_sann_pham.service;

import com.example.quan_ly_sann_pham.model.Category;
import com.example.quan_ly_sann_pham.repository.Impl.CategoryRepositoryImpl;
import com.example.quan_ly_sann_pham.repository.ICategoryRepository;

import java.util.List;

public class CategoryServiceImpl implements CategoryService{
    private ICategoryRepository categoryRepository = new CategoryRepositoryImpl();
    @Override
    public Category findById(String id) {
        return null;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
