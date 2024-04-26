package com.example.demojstl.service;

import com.example.demojstl.bean.Student;

import java.util.List;

public interface StudentService {
    void create(Student student);
    void delete(String id);
    void update(Student student);
    List<Student> findAll();
    Student findById(String id);
}
