package com.example.library.repository.impl;


import com.example.library.connections.BaseRepository;
import com.example.library.model.Student;
import com.example.library.repository.IStudentRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements IStudentRepository {
    private BaseRepository baseRepository = new BaseRepository();

    private String FIND_ID_AND_NAME_OF_STUDENT = "select id_student, name_student from student";
    @Override
    public List<Student> Find_id_and_name_of_student() {
        List<Student> studentList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(FIND_ID_AND_NAME_OF_STUDENT);
            ResultSet resultSet = preparedStatement.executeQuery();
            Student student = null;
            while (resultSet.next()){
                String id_student = resultSet.getString("id_student");
                String name_student = resultSet.getString("name_student");
                student = new Student(id_student,name_student);
                studentList.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }
}
