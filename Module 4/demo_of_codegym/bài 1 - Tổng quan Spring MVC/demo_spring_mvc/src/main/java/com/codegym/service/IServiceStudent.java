package com.codegym.service;

import com.codegym.model.Student;

import java.util.List;

public interface IServiceStudent {
    List<Student> findAll();
    String showMessage();
}
