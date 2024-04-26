package com.codegym.repository;

import com.codegym.model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
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
    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Student> query = session.createQuery("from Student",Student.class);
        studentList = query.getResultList();
        session.close();
        return studentList;
    }

    @Override
    public boolean add(Student student) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        try {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.save(student);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Student findById(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
//       TypedQuery<Student> query = session.createNativeQuery("select * from student where id=:id",Student.class);
       TypedQuery<Student> query = session.createQuery("from Student where id=:id",Student.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }
}
