package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    boolean save(Product product);

    boolean update(Product product);

    boolean delete(int id);

    Product findById(int id);

    List<Product> search(String search);
}