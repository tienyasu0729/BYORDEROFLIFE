package com.example.thi_module_3_lan_2.Repository.Impl;

import com.example.thi_module_3_lan_2.Connections.BaseRepository;
import com.example.thi_module_3_lan_2.Repository.ITypeRepository;
import com.example.thi_module_3_lan_2.model.Type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeRepositoryImpl implements ITypeRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private String DISPLAY_TYPE = "select  * from type";

    @Override
    public List<Type> display_type() {
        List<Type> typeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(DISPLAY_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idType = resultSet.getInt("id_type");
                String nameType = resultSet.getString("name_type");
                typeList.add(new Type(idType,nameType));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return typeList;
    }
}
