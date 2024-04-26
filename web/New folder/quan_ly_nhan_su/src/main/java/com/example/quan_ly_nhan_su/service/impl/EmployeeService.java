package com.example.quan_ly_nhan_su.service.impl;

import com.example.quan_ly_nhan_su.model.Employee;
import com.example.quan_ly_nhan_su.repository.IEployeeRepository;
import com.example.quan_ly_nhan_su.repository.impl.EmployeeRepository;
import com.example.quan_ly_nhan_su.service.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    private IEployeeRepository EmployeeRepository = new EmployeeRepository();

    @Override
    public void addNewEmployee(Employee employee) {
        EmployeeRepository.addNewEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public List<Employee> listEmployee() {
        List<Employee> employeeList = this.EmployeeRepository.listEmployee();
        return employeeList;
    }

    @Override
    public List<Employee> findByNameOfJob() {
        return null;
    }

    @Override
    public List<Employee> findByStartDateOfJob() {
        return null;
    }

    @Override
    public List<Employee> findByEndDateOfJob() {
        return null;
    }
}
