package com.codegym.repository;

import com.codegym.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentRepository implements IStudentRepository {
    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1,"chanh1",1, new String[]{"JS","PHP","Java"}));
        studentList.add(new Student(2,"chanh2",1,new String[]{"SQL","PHP","Java"}));
        studentList.add(new Student(3,"chanh3",1,new String[]{"NODE JS","PHP","Java"}));
    }
    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public boolean add(Student student) {
        return studentList.add(student);
    }
}
