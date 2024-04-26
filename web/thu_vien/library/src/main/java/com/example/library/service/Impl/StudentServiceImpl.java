package com.example.library.service.Impl;



import com.example.library.model.Student;
import com.example.library.repository.impl.StudentRepositoryImpl;
import com.example.library.service.IStudentService;

import java.util.List;

public class StudentServiceImpl implements IStudentService {
    private StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();
    @Override
    public List<Student> Find_id_and_name_of_student() {
        return studentRepository.Find_id_and_name_of_student();
    }
}
