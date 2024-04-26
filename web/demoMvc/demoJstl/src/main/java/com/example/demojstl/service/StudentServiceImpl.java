package com.example.demojstl.service;

import com.example.demojstl.bean.Student;
import com.example.demojstl.repository.StudentRepository;
import com.example.demojstl.repository.StudentRepositoryImpl;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository = new StudentRepositoryImpl();
    @Override
    public void create(Student student) {
        studentRepository.create(student);
    }

    @Override
    public void delete(String id) {
        studentRepository.delete(id);
    }

    @Override
    public void update(Student student) {
        studentRepository.update(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(String id) {
        return studentRepository.findById(id);
    }
}
