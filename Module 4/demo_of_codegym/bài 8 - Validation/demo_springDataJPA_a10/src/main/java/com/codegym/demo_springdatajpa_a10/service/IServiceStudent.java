package com.codegym.demo_springdatajpa_a10.service;



import com.codegym.demo_springdatajpa_a10.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceStudent {
    List<Student> findAll();
    Page<Student> findAll(Pageable pageable,String name);
    String showMessage();
    boolean add(Student student);
    Student findById(int id);
}
