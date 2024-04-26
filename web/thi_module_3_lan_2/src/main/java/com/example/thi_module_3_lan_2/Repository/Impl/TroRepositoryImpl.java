package com.example.thi_module_3_lan_2.Repository.Impl;

import com.example.thi_module_3_lan_2.Connections.BaseRepository;
import com.example.thi_module_3_lan_2.Repository.ITroRepository;
import com.example.thi_module_3_lan_2.model.Tro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TroRepositoryImpl implements ITroRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private String DISPLAY_TRO = "SELECT phongtro.id_tro,phongtro.name,phongtro.phone_number,phongtro.start_date,phongtro.note, type.name_type FROM phongtro JOIN type ON phongtro.id_type = type.id_type ORDER BY phongtro.id_type;";
//    private String ADD_TRO = "INSERT INTO phongtro(id_tro,name,phone_number,start_date,id_type,note) VALUES (?, ?, ?, ?, ?, ?);";
    private String findById = "SELECT phongtro.id_tro,phongtro.name,phongtro.phone_number,phongtro.start_date,phongtro.note, type.name_type FROM phongtro JOIN type ON phongtro.id_type = type.id_type where ";
    private String findByName = "SELECT phongtro.id_tro,phongtro.name,phongtro.phone_number,phongtro.start_date,phongtro.note, type.name_type FROM phongtro JOIN type ON phongtro.id_type = type.id_type ORDER BY phongtro.id_type;";
    private String findByPhoneNumber = "SELECT phongtro.id_tro,phongtro.name,phongtro.phone_number,phongtro.start_date,phongtro.note, type.name_type FROM phongtro JOIN type ON phongtro.id_type = type.id_type ORDER BY phongtro.id_type;";

    private String DELETE_TRO = "delete from phongtro where id_tro = ?";
    private String ADD_TRO = "INSERT INTO phongtro(name,phone_number,start_date,id_type,note) VALUES (?, ?, ?, ?, ?);";
    @Override
    public List<Tro> display_tro() {
        List<Tro> troList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(DISPLAY_TRO);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String idTro =String.valueOf(resultSet.getInt("id_tro"));
                String name = resultSet.getString("name");
                String phoneNumber = resultSet.getString("phone_number");
                Date startDate = new Date(resultSet.getDate("start_date").getTime());
                String nameType = resultSet.getString("name_type");
                String note = resultSet.getString("note");
                troList.add(new Tro(idTro,name,phoneNumber,startDate,nameType,note));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return troList;
    }

    @Override
    public boolean add_tro(Tro tro) {
        try {
//            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(ADD_TRO);
//            preparedStatement.setString(1,tro.getIdTro());
//            preparedStatement.setString(2,tro.getName());
//            preparedStatement.setString(3,tro.getPhoneNumber());
//            preparedStatement.setDate(4,new java.sql.Date(tro.getStartDate().getTime()));
//            preparedStatement.setInt(5,tro.getIdType());
//            preparedStatement.setString(6,tro.getNote());
//            preparedStatement.executeUpdate();

            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(ADD_TRO);
//            preparedStatement.setString(1,tro.getIdTro());
            preparedStatement.setString(1,tro.getName());
            preparedStatement.setString(2,tro.getPhoneNumber());
            preparedStatement.setDate(3,new java.sql.Date(tro.getStartDate().getTime()));
            preparedStatement.setInt(4,tro.getIdType());
            preparedStatement.setString(5,tro.getNote());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(DELETE_TRO);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }


}
