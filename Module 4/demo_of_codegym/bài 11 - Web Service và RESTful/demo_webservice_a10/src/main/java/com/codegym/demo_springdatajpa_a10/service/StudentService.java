package com.codegym.demo_springdatajpa_a10.service;

import com.codegym.demo_springdatajpa_a10.common.AdminException;
import com.codegym.demo_springdatajpa_a10.model.Student;
import com.codegym.demo_springdatajpa_a10.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IServiceStudent{

    @Autowired
    private IStudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return  studentRepository.findAll();
    }

    @Override
    public Page<Student> findAll(Pageable pageable,String name) {
        return studentRepository.findStudentByNameContaining(pageable, name);
    }

    @Override
    public boolean add(Student student)  {
        Student student1 =studentRepository.save(student);
        return true;
    }

    @Override
    public boolean update(Student student) {
        studentRepository.save(student);
        return true;
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Student student) {
        studentRepository.delete(student);
    }
}
