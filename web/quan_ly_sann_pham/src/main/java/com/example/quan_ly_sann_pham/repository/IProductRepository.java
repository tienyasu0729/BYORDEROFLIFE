package com.example.quan_ly_sann_pham.repository;

import com.example.quan_ly_sann_pham.model.Product;

import java.util.List;

public interface IProductRepository {
    void addProduct(Product product);

    void updateProduct(Product product);

    //  int deleteProduct(String id);
    void deleteProduct(String id);

    List<Product> listProduct();

    List<Product> findByNameOfProduct(String findName);

    //    List<Employee> findByStartDateOfJob();
//    List<Employee> findByEndDateOfJob();
    Product findByIdOfProduct(String id);

}
