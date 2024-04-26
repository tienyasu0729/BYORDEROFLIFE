package com.example.quan_ly_sann_pham.service;

import com.example.quan_ly_sann_pham.model.Product;

import java.util.List;

public interface ProductService {
    void add(Product product);

    void update(Product product);

    List<Product> listProduct();

    //    int delete(String id);
    void delete(String id);
    List<Product> findByNameOfProduct(String name);
    Product findByIdOfProduct(String id);
}
