package com.example.exercise_hrm.service.impl;

import com.example.exercise_hrm.model.Employee;
import com.example.exercise_hrm.repository.EmployeeRepository;
import com.example.exercise_hrm.repository.impl.EmployeeRepositoryImpl;
import com.example.exercise_hrm.service.EmployeeService;

import java.sql.Date;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository repository = new EmployeeRepositoryImpl();

    @Override
    public void add(Employee employee) {
        repository.add(employee);
    }

    @Override
    public void update(Employee employee) {
        repository.update(employee);
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return repository.findById(id);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }

    @Override
    public List<Employee> findByNameJob(String jobName) {
        return repository.findByNameJob(jobName);
    }

    @Override
    public List<Employee> search(Date startDate, Date endDate) {
        return repository.search(startDate, endDate);
    }
}
