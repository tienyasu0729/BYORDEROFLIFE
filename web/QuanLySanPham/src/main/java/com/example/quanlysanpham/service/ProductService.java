package com.example.quanlysanpham.service;

import com.example.quanlysanpham.bean.Product;

import java.util.List;

public interface ProductService {
    List display();
    void create(Product product);
    void update(Product product);
    void delete(String id);
    Product findById(String id);
    Product findByName(String name);
}
