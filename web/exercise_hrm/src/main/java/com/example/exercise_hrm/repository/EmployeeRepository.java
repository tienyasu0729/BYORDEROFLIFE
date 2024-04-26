package com.example.exercise_hrm.repository;

import com.example.exercise_hrm.model.Employee;

import java.util.Date;
import java.util.List;

public interface EmployeeRepository {
    void add(Employee employee);

    void update(Employee employee);

    List<Employee> findAll();

    Employee findById(int id);

    boolean delete(int id);

    List<Employee> findByNameJob(String jobName);

    List<Employee> search(Date startDate, Date endDate);
}
