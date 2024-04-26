package com.example.library.repository;

import com.example.library.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> Find_id_and_name_of_student();
}
