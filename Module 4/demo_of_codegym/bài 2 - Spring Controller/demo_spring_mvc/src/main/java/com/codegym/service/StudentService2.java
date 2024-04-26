package com.codegym.service;

import com.codegym.model.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;


public class StudentService2 implements IServiceStudent {
    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public String showMessage() {
        return "Hello Student Service 2";
    }
}
