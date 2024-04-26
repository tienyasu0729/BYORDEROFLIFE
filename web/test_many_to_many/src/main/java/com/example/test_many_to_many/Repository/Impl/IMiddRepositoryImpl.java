package com.example.test_many_to_many.Repository.Impl;

import com.example.test_many_to_many.Connections.BaseRepository;
import com.example.test_many_to_many.Repository.IMiddRepository;
import com.example.test_many_to_many.Repository.IUserRepository;
import com.example.test_many_to_many.model.Midd;
import com.example.test_many_to_many.model.Role;
import com.example.test_many_to_many.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IMiddRepositoryImpl implements IMiddRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private String Display_all = "SELECT user.*, role.role FROM user JOIN midd ON user.idUser = midd.idUser JOIN role ON midd.idRole = role.idRole ORDER BY user.idUser;";
    private String add_midd = "INSERT INTO `midd` (`idUser`, `idRole`) VALUES (?,?)";

    @Override
    public List<Midd> list_midd() {
        List<Midd> middList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(Display_all);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idUser = resultSet.getInt("idUser");
                String fullName = resultSet.getString("fullName");
                String code = resultSet.getString("code");
                Date birthDate = new Date(resultSet.getDate("birthdate").getTime());
                LocalDateTime timeBuild = resultSet.getTimestamp("timeBuild").toLocalDateTime();
                User user = new User(idUser,fullName,code,birthDate,timeBuild);
                String roleName = resultSet.getString("role");
                Role role = new Role(roleName);
                middList.add(new Midd(user,role));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return middList;
    }

    @Override
    public Boolean add_midd(Midd midd) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(add_midd);
            preparedStatement.setInt(1, midd.getUser().getIdUser());
            preparedStatement.setInt(2, midd.getRole().getIdRole());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
