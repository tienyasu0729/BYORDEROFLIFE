package com.example.demojstl.repository;

import com.example.demojstl.bean.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepositoryImpl implements StudentRepository {
    private static Map<String, Student> studentMap;

    static {
        studentMap = new HashMap<>();
        studentMap.put("SV01", new Student("SV01", "Tai", 1, "Da Nang", 7.5f));
        studentMap.put("SV02", new Student("SV02", "Nam", 1, "Quang Nam", 9.5f));
        studentMap.put("SV03", new Student("SV03", "Luan", 0, "Da Nang", 6.5f));
        studentMap.put("SV04", new Student("SV04", "Nhan", 1, "Quang Ngai", 5.0f));
        studentMap.put("SV05", new Student("SV05", "Thao", 0, "<h1>Da Nang</h1>", 4.5f));
    }

    @Override
    public void create(Student student) {
        if (!studentMap.containsKey(student.getId())) {
            studentMap.put(student.getId(), student);
        }
    }

    @Override
    public void delete(String id) {
        studentMap.remove(id);
    }

    @Override
    public void update(Student student) {
        if (studentMap.containsKey(student.getId())) {
            studentMap.put(student.getId(), student);
        }
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public Student findById(String id) {
        return studentMap.get(id);
    }
}
