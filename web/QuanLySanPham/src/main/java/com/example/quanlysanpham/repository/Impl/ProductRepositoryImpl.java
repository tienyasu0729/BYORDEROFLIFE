package com.example.quanlysanpham.repository.Impl;

import com.example.quanlysanpham.bean.Product;
import com.example.quanlysanpham.repository.ProductRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private static List<Product> productList = new ArrayList<>();
    private Repository repository = new Repository();

//    static {
//        productList.add(new Product("dv001", "tien1", 1000, "a1","tienthanh1"));
//        productList.add(new Product("dv002", "tien2", 2000, "a2","tienthanh2"));
//        productList.add(new Product("dv003", "tien3", 3000, "a3","tienthanh3"));
//        productList.add(new Product("dv004", "tien4", 4000, "a4","tienthanh4"));
//        productList.add(new Product("dv005", "tien5", 5000, "a5","tienthanh5"));
//    }
    @Override
    public List display() {
        List<Product> productList1 = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.repository.getConnectionJavaToDB().prepareStatement("select * from test");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                String describe = resultSet.getString("describeproduct");
                String producer = resultSet.getString("producer");
                productList1.add(new Product(id,name,price,describe,producer));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList1;
    }

    @Override
    public void create(Product creaseProduct) {
        try {
            PreparedStatement preparedStatement = this.repository.getConnectionJavaToDB().
                    prepareStatement("insert into testjdbc(id,name,ptice,describe_product,producer) values (?,?,?,?,?)");
            preparedStatement.setString(1, creaseProduct.getId());
            preparedStatement.setString(2, creaseProduct.getName());
            preparedStatement.setInt(3, creaseProduct.getPrice());
            preparedStatement.setString(4, creaseProduct.getDescribe());
            preparedStatement.setString(5, creaseProduct.getProducer());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
