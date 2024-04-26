package vn.codegym.service;

import vn.codegym.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    Product findById(Long id);

    void save(Product product);

}
