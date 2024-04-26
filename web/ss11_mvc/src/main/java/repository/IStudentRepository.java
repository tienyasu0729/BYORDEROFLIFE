package repository;

import model.Student;

import java.util.List;

public interface IStudentRepository{
    void save(Student student);

    List<Student> getAll();

    Student findById(int id);

    void deleteById(int id);
}
