package com.example.retake_module_3.Repository.Impl;


import com.example.retake_module_3.Connections.BaseRepository;
import com.example.retake_module_3.Repository.Android_PhoneRepository;
import com.example.retake_module_3.model.Android_Phone;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Android_PhoneRepositoryImpl implements Android_PhoneRepository {
    private BaseRepository baseRepository = new BaseRepository();

    private String DISPLAY_LIST = "";
    private String ADD = "";
    private String EDIT = "";
    private String DELETE = "";
    private String FIND_BY_ID = "";
    private String FIND_BY_NAME = "";

    @Override
    public List<Android_Phone> list() {
        List<Android_Phone> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(DISPLAY_LIST);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

                list.add(new Android_Phone());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Boolean add(Android_Phone y) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(ADD);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public Boolean edit(Android_Phone y) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(EDIT);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public Boolean delete(int idNeedDelete) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(DELETE);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }    }

    @Override
    public List<Android_Phone> findById(int idNeedFind) {
        List<Android_Phone> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(FIND_BY_ID);
            preparedStatement.setInt();

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

                list.add(new Android_Phone());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<Android_Phone> findByName(int idNeedFind) {
        List<Android_Phone> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(FIND_BY_NAME);
            preparedStatement.setInt();

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

                list.add(new Android_Phone());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;    }
}
