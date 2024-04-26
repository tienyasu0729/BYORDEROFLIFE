package com.codegym.demo_springdatajpa_a10.service;



import com.codegym.demo_springdatajpa_a10.model.Student;

import java.util.List;

public interface IServiceStudent {
    List<Student> findAll();
    String showMessage();
    boolean add(Student student);
    Student findById(int id);
}
