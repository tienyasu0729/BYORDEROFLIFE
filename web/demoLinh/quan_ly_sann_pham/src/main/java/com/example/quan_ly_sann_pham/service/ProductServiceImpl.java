package com.example.quan_ly_sann_pham.service;


import com.example.quan_ly_sann_pham.model.Product;
import com.example.quan_ly_sann_pham.repository.IProductRepository;
import com.example.quan_ly_sann_pham.repository.Impl.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private IProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public void add(Product product) {
        productRepository.addProduct(product);
    }

    @Override
    public void update(Product product) {
        productRepository.updateProduct(product);
    }

    @Override
    public List<Product> listProduct() {
        return productRepository.listProduct();
    }

    //    @Override
//    public int delete(String id) {
//        return productRepository.deleteProduct(id);
//    }
    @Override
    public void delete(String id) {
        productRepository.deleteProduct(id);
    }

    @Override
    public List<Product> findByNameOfProduct(String name) {
        return productRepository.findByNameOfProduct(name);
    }
}
