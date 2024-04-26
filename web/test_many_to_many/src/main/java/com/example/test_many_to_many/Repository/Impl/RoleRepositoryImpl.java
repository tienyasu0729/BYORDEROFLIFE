package com.example.test_many_to_many.Repository.Impl;

import com.example.test_many_to_many.Connections.BaseRepository;
import com.example.test_many_to_many.Repository.IRoleRepository;
import com.example.test_many_to_many.model.Role;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleRepositoryImpl implements IRoleRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private String display_role = "select * from role";
    @Override
    public List<Role> display_role() {
        List<Role> roleList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(display_role);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("idRole");
                String role = resultSet.getString("role");
                roleList.add(new Role(id,role));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return roleList;
    }
}
