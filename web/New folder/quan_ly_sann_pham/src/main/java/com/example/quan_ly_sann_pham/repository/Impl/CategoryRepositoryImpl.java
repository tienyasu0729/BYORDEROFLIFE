package com.example.quan_ly_sann_pham.repository.Impl;

import com.example.quan_ly_sann_pham.connection.BaseRepository;
import com.example.quan_ly_sann_pham.model.Category;
import com.example.quan_ly_sann_pham.repository.ICategoryRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements ICategoryRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_CATEGORY = "select * from category";



    @Override
    public Category findById(String id) {
        return null;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categoryList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(SELECT_ALL_CATEGORY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("idcategory");
                String name = resultSet.getString("namecategory");
                categoryList.add(new Category(id, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categoryList;
    }
}
