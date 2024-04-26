package com.example.quan_ly_nhan_su.repository;

import com.example.quan_ly_nhan_su.model.Employee;

import java.util.List;

public interface IEployeeRepository {
    void addNewEmployee(Employee employee);
    void updateEmployee(Employee employee);
    List<Employee> listEmployee();
    List<Employee> findByNameOfJob();
    List<Employee> findByStartDateOfJob();
    List<Employee> findByEndDateOfJob();

}
