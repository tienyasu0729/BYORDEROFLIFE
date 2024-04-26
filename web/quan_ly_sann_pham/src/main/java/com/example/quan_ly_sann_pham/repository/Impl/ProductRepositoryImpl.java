package com.example.quan_ly_sann_pham.repository.Impl;

import com.example.quan_ly_sann_pham.connection.BaseRepository;
import com.example.quan_ly_sann_pham.model.Product;
import com.example.quan_ly_sann_pham.repository.IProductRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class ProductRepositoryImpl implements IProductRepository {

    private BaseRepository baseRepository = new BaseRepository();
    private static final String LIST_PRODUCT = "select * from product;";
    private static final String ADD_NEW_PRODUCT = "INSERT INTO product(name, price, quantity, color, description, idcategory ) VALUES (?, ?, ?, ?, ?, ?);";

    private static final String DELETE_PRODUCT = "DELETE FROM PRODUCT WHERE id = ?;";

    private static final String EDIT_PRODUCT = "UPDATE product SET name = ?, price = ?, quantity = ?, color = ?, description = ?, idcategory = ? WHERE id = ?;";

    private static final String FIND_BY_NAME = "SELECT * FROM product WHERE name LIKE ?";

    private static final String FIND_BY_ID = "SELECT * FROM product WHERE id = ?";
    @Override
    public void addProduct(Product product) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(ADD_NEW_PRODUCT);
//            preparedStatement.setString(1, product.getId());
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor().toString());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setString(6, product.getIdCategory());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateProduct(Product product) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(EDIT_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor().toString());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setString(6, product.getIdCategory());
            preparedStatement.setString(7, product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> listProduct() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(LIST_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                String category = resultSet.getString("idcategory");
                products.add(new Product(id, name, price, quantity, color, description, category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    //    @Override
//    public int deleteProduct(String id) {
//        int check = 0;
//        try {
//            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(DELETE_PRODUCT);
//            preparedStatement.setString(1, id);
//            check = preparedStatement.executeUpdate();
//            return check;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
    @Override
    public void deleteProduct(String id) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(DELETE_PRODUCT);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public List<Product> findByNameOfProduct(String findName) {

        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(FIND_BY_NAME);
            preparedStatement.setString(1, findName + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                String category = resultSet.getString("idcategory");
                products.add(new Product(id, name, price, quantity, color, description, category));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

    @Override
    public Product findByIdOfProduct(String id) {
        Product product = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(FIND_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                String category = resultSet.getString("idcategory");
                product = new Product(id, name, price, quantity, color, description, category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return product;
    }
}
