package com.codegym.demo_springdatajpa_a10.controller;

import com.codegym.demo_springdatajpa_a10.common.AdminException;
import com.codegym.demo_springdatajpa_a10.dto.StudentDto;
import com.codegym.demo_springdatajpa_a10.model.Student;
import com.codegym.demo_springdatajpa_a10.service.IServiceStudent;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/student")
public class RestStudentController {
    @Autowired
    private IServiceStudent serviceStudent;

    @GetMapping("")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> studentList = serviceStudent.findAll();
        if (studentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> add(@RequestBody StudentDto studentDto) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        serviceStudent.add(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("")
    public ResponseEntity<?> delete(@RequestParam int id) {
        Student student = serviceStudent.findById(id);
        if (student==null){
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            serviceStudent.delete(student);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete2(@PathVariable int id) {
        Student student = serviceStudent.findById(id);
        if (student==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            serviceStudent.delete(student);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    @PatchMapping("")
//    @PutMapping("")
    public ResponseEntity<?> update(@RequestParam int id,@RequestBody StudentDto studentDto) {
        Student student = serviceStudent.findById(id);
        if (student==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            BeanUtils.copyProperties(studentDto,student);
            serviceStudent.update(student);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
