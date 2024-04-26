package com.example.quanlysanpham.service;

import com.example.quanlysanpham.bean.Product;
import com.example.quanlysanpham.repository.Impl.ProductRepositoryImpl;
import com.example.quanlysanpham.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService{
    private ProductRepository productService = new ProductRepositoryImpl();
    @Override
    public List display() {
        List<Product> productList = this.productService.display();
        return productList;
    }

    @Override
    public void create(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Product findById(String id) {
        return null;
    }

    @Override
    public Product findByName(String name) {
        return null;
    }
}
