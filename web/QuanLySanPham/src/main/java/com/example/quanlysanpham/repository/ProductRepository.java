package com.example.quanlysanpham.repository;

import com.example.quanlysanpham.bean.Product;

import java.util.List;

public interface ProductRepository {
    List display();
    void create(Product creaseProduct);
    void update(Product product);
    void delete(String id);
    Product findById(String id);
    Product findByName(String name);
}
