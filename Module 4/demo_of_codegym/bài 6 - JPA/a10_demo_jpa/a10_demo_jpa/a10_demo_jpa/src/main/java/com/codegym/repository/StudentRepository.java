package com.codegym.repository;

import com.codegym.model.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1,"chanh1",1));
        studentList.add(new Student(2,"chanh2",0));
        studentList.add(new Student(3,"chanh3",-1));
    }
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
//        HQL
//        studentList = entityManager.createQuery("from Student").getResultList();
//       SQL
        TypedQuery<Student> query = (TypedQuery<Student>) entityManager.createNativeQuery("select * from student",Student.class);
        studentList = query.getResultList();
        return studentList;
    }

    @Transactional
    @Override
    public boolean add(Student student) {
        try {
            entityManager.persist(student);
            // xoá thì sao
//            Student student1 = findById(student.getId());
//            entityManager.remove(student1);
            // update
//            Student student1 = findById(student.getId());
//            student1.setName(student.getName());
//            entityManager.merge(student1);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class,id);
    }
}
