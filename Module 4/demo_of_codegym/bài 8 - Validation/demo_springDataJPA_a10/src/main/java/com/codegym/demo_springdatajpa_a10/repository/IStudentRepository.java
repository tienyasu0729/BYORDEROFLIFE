package com.codegym.demo_springdatajpa_a10.repository;



import com.codegym.demo_springdatajpa_a10.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student,Integer> {

    // theo câu querry theo method name
 List<Student> findStudentByNameContaining(String name);
// tạo câu query thuần
 @Query(value = "select * from student where name like :name",nativeQuery = true)
 List<Student> searchByName(@Param("name") String name);
 Page<Student> findStudentByNameContaining(Pageable pageable,String name);
}
