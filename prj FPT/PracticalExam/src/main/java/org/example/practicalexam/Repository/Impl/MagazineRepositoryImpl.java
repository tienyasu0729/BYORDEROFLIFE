package org.example.practicalexam.Repository.Impl;

import org.example.practicalexam.Repository.MagazineRepository;
import org.example.practicalexam.connection_config.BaseRepositoryJDBC;
import org.example.practicalexam.model.Magazine;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MagazineRepositoryImpl implements MagazineRepository {
    private BaseRepositoryJDBC baseRepository = new BaseRepositoryJDBC();
    private String getCourse = "select * from magazine_de170390";
    private String addCourse = "INSERT INTO magazine_de170390 (Maz_ID, Magazine_Title, Publisher, Price) VALUES (?, ?, ?, ?)";

    @Override
    public List<Magazine> getAll() {
        List<Magazine> magazineList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(getCourse);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String mazID = resultSet.getString("Maz_ID");
                String magazineTitle = resultSet.getString("Magazine_Title");
                String publisher = resultSet.getString("Publisher");
                int Credits = resultSet.getInt("Price");
                magazineList.add(new Magazine(mazID,magazineTitle,publisher,Credits));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return magazineList;
    }

    @Override
    public void newMagazine(Magazine magazine) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(addCourse);
            preparedStatement.setString(1, magazine.getMazID());
            preparedStatement.setString(2, magazine.getMagazineTitle());
            preparedStatement.setString(3, magazine.getPublisher());
            preparedStatement.setInt(4, magazine.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
