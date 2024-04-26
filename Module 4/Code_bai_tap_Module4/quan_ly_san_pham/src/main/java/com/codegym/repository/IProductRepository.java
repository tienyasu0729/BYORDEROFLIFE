package com.codegym.repository;


import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    boolean save(Product product);

    boolean update(Product product);

    boolean delete(int id);

    Product findById(int id);

    List<Product> search(String search);
}