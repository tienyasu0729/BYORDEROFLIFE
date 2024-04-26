package service;

import model.Student;

import java.util.List;
import java.util.Map;

public interface IStudentService {

    Map<String, String> save(Student student);

    List<Student> getAll();

    Student findById(int id);

    void deleteById(int id);
}
